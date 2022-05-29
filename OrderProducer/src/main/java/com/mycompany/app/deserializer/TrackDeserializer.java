package com.mycompany.app.deserializer;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.fernanda.maia.kafka.avro.Track;
import lombok.SneakyThrows;
public class TrackDeserializer implements Deserializer<Track> {
    @Override
    @SneakyThrows
    public Track deserialize(String topic, byte[] data) {
        Track response = null;
        ObjectMapper mapper = new ObjectMapper();
        response = mapper.readValue(data, Track.class);
        return response;
    }
}
