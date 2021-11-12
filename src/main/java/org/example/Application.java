package org.example;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;

import java.util.Properties;

public class Application {
    public static void main(String[] args) {
        final var properties = new Properties();
        // Change properties however you need
        properties.setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "test-app");
        properties.setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(StreamsConfig.REPLICATION_FACTOR_CONFIG, "1");
        final var inputTopic = "input";
        final var outputTopic = "output";

        final var streams = new KafkaStreams(generateTopology(inputTopic, outputTopic), properties);
        streams.cleanUp(); // Don't do in production
        streams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }

    public static Topology generateTopology(String inputTopic, String outputTopic) {
        final var builder = new StreamsBuilder();

        // Code here

        return builder.build();
    }
}
