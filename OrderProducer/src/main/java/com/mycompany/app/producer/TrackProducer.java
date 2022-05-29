package com.mycompany.app.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.mycompany.app.partition.VIPPartitioner;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.github.fernanda.maia.kafka.avro.Track;

public class TrackProducer {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://localhost:9092");
		props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
		props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
		props.setProperty("partitioner.class", VIPPartitioner.class.getName());
		props.setProperty(ProducerConfig.ACKS_CONFIG, "1");
		props.setProperty(ProducerConfig.BUFFER_MEMORY_CONFIG, "1MB");
		props.setProperty(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy");
		props.setProperty(ProducerConfig.RETRIES_CONFIG, "2");
		props.setProperty(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, "400");
		props.setProperty(ProducerConfig.BATCH_SIZE_CONFIG,"1024000");
		props.setProperty(ProducerConfig.LINGER_MS_CONFIG,"500");
		props.setProperty(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG,"200");
		
		try (KafkaProducer<Long, Track> producer = new KafkaProducer<>(props)) {
			for (int i = 0; i < 10; i++) {
				Track track = Track.newBuilder().setId(i).setLatitude("20.576N").setLongitude("89.3639E").build();
				ProducerRecord<Long, Track> record = new ProducerRecord<>("OrderPartitionedTopic", track.getId(),
						track);
				System.out.println("Reached 2" + record);
				System.out.println("Sending to Topic ");
				System.out.println("Partition Info " + record.partition());
				producer.send(record);
			}

		} catch (Exception e) {
			System.out.println("Reached 1");
			e.printStackTrace();
		} finally {
			System.out.println("Reached 2");
		}
	}
}