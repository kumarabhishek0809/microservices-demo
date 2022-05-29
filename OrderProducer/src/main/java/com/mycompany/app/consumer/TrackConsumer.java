package com.mycompany.app.consumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.clients.consumer.OffsetCommitCallback;
import org.apache.kafka.common.TopicPartition;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.github.fernanda.maia.kafka.avro.Track;

public class TrackConsumer {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://localhost:9092");
		props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
		props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
		props.setProperty("schema.registry.url", "http://localhost:8081");
		props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "TrackGroup");
		props.setProperty("specific.avro.reader", "true");
		props.setProperty("auto.commit.offset", "false");
		props.setProperty(ConsumerConfig.FETCH_MIN_BYTES_CONFIG, "10000000");
		props.setProperty(ConsumerConfig.FETCH_MAX_WAIT_MS_CONFIG, "200");
		props.setProperty(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, "1000");
		props.setProperty(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "3000");

		Map<TopicPartition, OffsetAndMetadata> currentOffsets = new HashMap();
		KafkaConsumer<Long, Track> consumer = new KafkaConsumer<>(props);

		class RebalanceHandler implements ConsumerRebalanceListener {

			@Override
			public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
				consumer.commitSync(currentOffsets);

			}

			@Override
			public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
				// TODO Auto-generated method stub

			}

		}

		consumer.subscribe(Arrays.asList("OrderPartitionedTopic"), new RebalanceHandler());
		try {
			while (true) {
				ConsumerRecords<Long, Track> records = consumer.poll(Duration.ofSeconds(20));
				System.out.println("TOTAL COUNT OF COLLECT " + records.count());
				int count = 0;

				for (ConsumerRecord<Long, Track> c : records) {
					Track coordinates = c.value();
					System.out.println("ID: " + c.key());
					System.out.println("LATITUDE: " + coordinates.getLatitude());
					System.out.println("LONGITUDE: " + coordinates.getLongitude());

					currentOffsets.put(new TopicPartition(c.topic(), c.partition()),
							new OffsetAndMetadata(c.offset() + 1));

					if (count % 10 == 0) {

						consumer.commitAsync(currentOffsets, new OffsetCommitCallback() {
							@Override
							public void onComplete(Map<TopicPartition, OffsetAndMetadata> offsets,
									Exception exception) {
							}
						});
					}
					count++;

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}