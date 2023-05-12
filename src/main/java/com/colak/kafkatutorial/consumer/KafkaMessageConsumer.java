package com.colak.kafkatutorial.consumer;

import com.colak.kafkatutorial.producer.KafkaTopicConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class KafkaMessageConsumer {
    /*
    @KafkaListener(topics = KafkaTopicConfig.TOPIC_NAME, groupId = "my-group-id5")
    @KafkaListener(topics = "my-topic", groupId = "my-group-id")
    public void listen(@Payload(required = false) String value, @Headers Map<String, Object> headers) {
        String key = (String) headers.get("kafka_receivedMessageKey");
        System.out.println("Received key : " + key + " value: " + value);
        // Process the message as per your requirement
    }*/

    @KafkaListener(topics = KafkaTopicConfig.TOPIC_NAME, groupId = "my-group-id6")
    @KafkaListener(topics = "my-topic", groupId = "my-group-id")
    public void listen(ConsumerRecord<String, String> record) {
        String key = record.key();
        String value = record.value();
        System.out.println("Received key : " + key + " value: " + value);
        // Process the message as per your requirement
    }
}
