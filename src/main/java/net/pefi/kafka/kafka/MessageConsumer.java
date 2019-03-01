package net.pefi.kafka.kafka;

import net.pefi.kafka.model.SimpleMessage;
import net.pefi.kafka.socket.SocketSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    private SimpMessagingTemplate template;

    @Autowired
    public MessageConsumer(SimpMessagingTemplate template) {
        this.template = template;
    }

    @SendTo({"/topic/messages"})
    @KafkaListener(topics = "${cloudkarafka.topic}")
    public void processMessage(SimpleMessage message) {
        try {
            SocketSender.setTemplate(template);
            SocketSender.send(message);
        } catch (Exception e) {
            System.out.print("Failed to send message");
        }
    }

}
