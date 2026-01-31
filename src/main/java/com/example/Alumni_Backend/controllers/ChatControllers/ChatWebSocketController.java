package com.example.Alumni_Backend.controllers.ChatControllers;

import com.example.Alumni_Backend.DTO.MessagingDTOs.ChatMessage;
import com.example.Alumni_Backend.models.Messaging.Message;
import com.example.Alumni_Backend.models.User;
import com.example.Alumni_Backend.services.MessagingServices.MessageService;
import com.example.Alumni_Backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1")
public class ChatWebSocketController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    private UserService userService;


    @MessageMapping("/chat.send")
//    @PostMapping("/alumni/send")
    public void send(ChatMessage dto) {

        User sender = userService.getById(dto.senderId);
        User receiver = userService.getById(dto.receiverId);

        Message saved = messageService.send(
                sender,
                receiver,
                dto.content
        );

        messagingTemplate.convertAndSendToUser(
                receiver.getId().toString(),
                "/queue/messages",
                saved
        );
        System.out.println("Method executed successfully");
    }
}
