package com.example.Alumni_Backend.controllers.ChatControllers;

import com.example.Alumni_Backend.DTO.MessagingDTOs.ChatMessage;
import com.example.Alumni_Backend.models.Messaging.Message;
import com.example.Alumni_Backend.models.User;
import com.example.Alumni_Backend.repository.UserRepo;
import com.example.Alumni_Backend.services.MessageService;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class ChatController {
    private final SimpMessagingTemplate messagingTemplate;
    private final MessageService messageService;
    private final UserRepo userRepository;

    public ChatController(
            SimpMessagingTemplate messagingTemplate,
            MessageService messageService,
            UserRepo userRepository) {

        this.messagingTemplate = messagingTemplate;
        this.messageService = messageService;
        this.userRepository = userRepository;
    }

    @MessageMapping("/chat.send")
    public void sendMessage(
            @Payload ChatMessage chatMessage,
            Principal principal) {

        // 1️⃣ Extract sender from JWT
        String senderEmail = principal.getName();

        User sender = userRepository.findByEmail(senderEmail)
                .orElseThrow();

        User receiver = userRepository.findByEmail(chatMessage.getReceiverEmail())
                .orElseThrow();

        // 2️⃣ Save message
        Message saved = messageService.save(sender, receiver, chatMessage.getContent());

        // 3️⃣ Send to receiver
        messagingTemplate.convertAndSendToUser(
                receiver.getEmail(),
                "/queue/messages",
                saved
        );
    }
}
