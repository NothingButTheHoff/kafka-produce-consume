package net.pefi.kafka.controller;

import net.pefi.kafka.model.SimpleMessage;
import net.pefi.kafka.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/message")
    public void postMessage(String message, String name) {
        messageService.sendMessage(message, name);
    }

    //socket
    @MessageMapping("/chat")
    @SendTo({"/topic/messages"})
    public SimpleMessage send(SimpleMessage message) {
        return message;
    }
}
