package com.colak.kafkatutorial.consumer;

import com.colak.kafkatutorial.producer.KafkaTopicConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConsumerSeekAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class FromBeginningKafkaMessageConsumer implements ConsumerSeekAware {


    @Override
    public void onPartitionsAssigned(Map<TopicPartition, Long> assignments, ConsumerSeekCallback callback) {
        // Seek to the beginning of each assigned partition
        assignments.keySet().forEach(
                topicPartition -> callback.seekToBeginning(topicPartition.topic(), topicPartition.partition()));

    }

    @KafkaListener(topics = KafkaTopicConfig.TOPIC_NAME)
    public void listen(ConsumerRecord<String, String> record) {
        String key = record.key();
        String value = record.value();
        log.info("Received key : {} value : {}", key, value);
        // Process the message as per your requirement
    }
}
