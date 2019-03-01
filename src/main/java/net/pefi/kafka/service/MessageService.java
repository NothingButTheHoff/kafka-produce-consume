package net.pefi.kafka.service;

import net.pefi.kafka.kafka.MessageProducer;
import net.pefi.kafka.model.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private MessageProducer messageProducer;

    @Autowired
    public MessageService(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    public void sendMessage(String text, String name) {
        messageProducer.send(new SimpleMessage(text, name));
    }
}
