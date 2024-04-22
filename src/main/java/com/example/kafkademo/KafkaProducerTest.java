package com.example.kafkademo;/*
 * Copyright (c) 2014-2022 Huami, Inc. All Rights Reserved.
 */

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

public class KafkaProducerTest implements Runnable {

    private final KafkaProducer<String, String> producer;
    private final String topic;

    public KafkaProducerTest(String topicName) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());
        props.put("session.timeout.ms", "30000");
        props.put("auto.offset.reset", "earliest");
        props.put("buffer.memory", 33554432);
        props.put("batch.size", 16384);
        props.put("linger.ms", 20000);
        props.put("retries", 3);
        props.put("retry.backoff.ms", 500);
        props.put("acks", "1");
        this.producer = new KafkaProducer<>(props);
        this.topic = topicName;
    }

    @Override
    public void run() {
        System.out.println("---------开始生产消息---------");
        try {
            for (; ; ) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String str = reader.readLine();
                producer.send(new ProducerRecord<>(topic, "Message", str));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }

    public static void main(String args[]) {
        KafkaProducerTest test = new KafkaProducerTest("test");
        Thread thread = new Thread(test);
        thread.start();
    }
}