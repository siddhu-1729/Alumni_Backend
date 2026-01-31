package com.example.Alumni_Backend.controllers.ChatControllers;

import com.example.Alumni_Backend.models.Messaging.Conversation;
import com.example.Alumni_Backend.models.Messaging.Message;
import com.example.Alumni_Backend.repository.MessagingRepos.ConversationRepo;
import com.example.Alumni_Backend.repository.MessagingRepos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private ConversationRepo conversationRepo;

    @GetMapping("/conversation/{id}")
    public List<Message> getMessages(@PathVariable Long id) {
        Conversation c = conversationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        return messageRepo.findByConversationOrderBySentAtAsc(c);
    }
}
