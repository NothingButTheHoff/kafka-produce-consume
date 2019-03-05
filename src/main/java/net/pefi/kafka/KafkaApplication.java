package net.pefi.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {
        System.out.println("burde funke");
        SpringApplication.run(KafkaApplication.class, args);
    }

}
