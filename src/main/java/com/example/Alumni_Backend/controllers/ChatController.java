//package com.example.Alumni_Backend.controllers;
//
//import com.example.Alumni_Backend.models.ChatMessage;
//import com.example.Alumni_Backend.repository.ChatMessageRepo;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Controller;
//
//import java.time.LocalDateTime;
//
//@Controller
//public class ChatController {
//
//    private final SimpMessagingTemplate messagingTemplate;
//    private final ChatMessageRepo repo;
//
//    public ChatController(SimpMessagingTemplate messagingTemplate,
//                          ChatMessageRepo repo) {
//        this.messagingTemplate = messagingTemplate;
//        this.repo = repo;
//    }
//
//    // One-to-one messaging
//    @MessageMapping("/chat.private")
//    public void sendPrivateMessage(ChatMessage message) {
//        message.setTimestamp(LocalDateTime.now());
//        repo.save(message);
//
//        messagingTemplate.convertAndSendToUser(
//                message.getReceiver(),
//                "/queue/messages",
//                message
//        );
//    }
//
//    // Group messaging
//    @MessageMapping("/chat.public")
//    @SendTo("/topic/public")
//    public ChatMessage sendPublic(ChatMessage message) {
//        message.setTimestamp(LocalDateTime.now());
//        repo.save(message);
//        return message;
//    }
//}
//
