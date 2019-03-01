package net.pefi.kafka.socket;

import net.pefi.kafka.model.SimpleMessage;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class SocketSender {
    private static SimpMessagingTemplate template;

    public static void setTemplate(SimpMessagingTemplate template) {
        SocketSender.template = template;
    }

    public static void send(SimpleMessage simpleMessage) {
        template.convertAndSend("/topic/messages", simpleMessage);
    }
}


