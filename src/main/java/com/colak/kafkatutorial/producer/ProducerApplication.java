package com.colak.kafkatutorial.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {

    @Autowired
    KafkaMessageSender kafkaMessageSender;

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Override
    public void run(String... args) {
        kafkaMessageSender.sendMessage("key1", "value1");
//        kafkaMessageSender.sendMessage("key1",null);
    }
}
