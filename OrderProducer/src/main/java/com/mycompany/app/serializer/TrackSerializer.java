package com.mycompany.app.serializer;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.fernanda.maia.kafka.avro.Track;
import lombok.SneakyThrows;
public class TrackSerializer implements Serializer<Track> {
    @Override
    @SneakyThrows
    public byte[] serialize(String topic, Track track) {
        ObjectMapper mapper = new ObjectMapper();
        byte[] response = mapper.writeValueAsString(track).getBytes();
        return response;
    }
}
