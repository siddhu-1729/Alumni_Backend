package com.example.Alumni_Backend.controllers.MessageControllers;

import com.example.Alumni_Backend.DTO.MessageDTO;
import com.example.Alumni_Backend.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/send")
public class ChatController {

    @Autowired
    private NotificationService notificationService;

//    Clients sends message to /app/chat-send and spring broadcasts the returned message to everyone who are
//    Subscribed to /topic/global-chat
    @MessageMapping("/chat-send")
    @SendTo("/topic/student-chat")
    public MessageDTO globalChat(Principal principal,MessageDTO messageDTO){
         String sender=principal!=null ? principal.getName() : messageDTO.getSender();

//        notificationService.sendMessage(messageDTO);
        return new MessageDTO(sender, messageDTO.getContent());
    }
}
