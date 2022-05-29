package com.mycompany.app;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.github.fernanda.maia.kafka.avro.Track;

public class TrackProducer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "http://localhost:9092");
        props.setProperty("key.serializer", KafkaAvroSerializer.class.getName());
        props.setProperty("value.serializer",
                KafkaAvroSerializer.class.getName());
        props.setProperty("schema.registry.url", "http://localhost:8081");
        try(KafkaProducer<Long, Track> producer = new
                KafkaProducer<>(props)) {
            Track track = Track.newBuilder()
                    .setId(1L)
                    .setLatitude("20.576N")
                    .setLongitude("89.3639E")
                    .build();
            ProducerRecord<Long, Track> record = new
                    ProducerRecord<>("TrackAvroTopic", track.getId(), track);
            producer.send(record);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}