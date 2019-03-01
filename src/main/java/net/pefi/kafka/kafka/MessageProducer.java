package net.pefi.kafka.kafka;

import net.pefi.kafka.model.SimpleMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class MessageProducer {

    private KafkaTemplate<String, SimpleMessage> kafkaTemplate;

    @Value("${cloudkarafka.topic}")
    private String topic;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    MessageProducer(KafkaTemplate<String, SimpleMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(SimpleMessage message) {
        kafkaTemplate.send(topic, message);
    }
}
