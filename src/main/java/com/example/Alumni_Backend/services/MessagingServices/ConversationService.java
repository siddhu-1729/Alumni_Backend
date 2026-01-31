package com.example.Alumni_Backend.services.MessagingServices;

import com.example.Alumni_Backend.models.Messaging.Conversation;
import com.example.Alumni_Backend.models.User;
import com.example.Alumni_Backend.repository.MessagingRepos.ConversationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversationService {
    @Autowired
    private ConversationRepo conversationRepo;

    public Conversation getOrCreate(User student, User alumni) {
        return conversationRepo
                .findByStudentAndAlumni(student, alumni)
                .orElseGet(() -> {
                    Conversation c = new Conversation();
                    c.setStudent(student);
                    c.setAlumni(alumni);
                    return conversationRepo.save(c);
                });
    }
}
