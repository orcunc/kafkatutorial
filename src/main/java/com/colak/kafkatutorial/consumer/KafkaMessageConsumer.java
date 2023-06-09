package com.colak.kafkatutorial.consumer;

import com.colak.kafkatutorial.producer.KafkaTopicConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class KafkaMessageConsumer {
    /*
    @KafkaListener(topics = KafkaTopicConfig.TOPIC_NAME, groupId = "my-group-id5")
    public void listen(@Payload(required = false) String value, @Headers Map<String, Object> headers) {
        String key = (String) headers.get("kafka_receivedMessageKey");
        log.info("Received key : {} value : {}", key, value);
        // Process the message as per your requirement
    }*/

    @KafkaListener(topics = KafkaTopicConfig.TOPIC_NAME)
    public void listen(ConsumerRecord<String, String> record) {
        String key = record.key();
        String value = record.value();
        log.info("Received key : {} value : {}", key, value);
        // Process the message as per your requirement
    }
}
