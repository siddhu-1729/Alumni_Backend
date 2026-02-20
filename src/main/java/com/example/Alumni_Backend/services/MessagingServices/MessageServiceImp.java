package com.example.Alumni_Backend.services.MessagingServices;

import com.example.Alumni_Backend.models.Messaging.Message;
import com.example.Alumni_Backend.models.Role;
import com.example.Alumni_Backend.models.User;
import com.example.Alumni_Backend.repository.MessagingRepos.MessageRepo;
import com.example.Alumni_Backend.repository.UserRepo;
import com.example.Alumni_Backend.services.MessageService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class MessageServiceImp implements MessageService {

    private final MessageRepo messageRepository;
    private final UserRepo userRepository;

    public MessageServiceImp(MessageRepo messageRepository, UserRepo userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    //  Save message
    public Message save(User sender, User receiver, String content) {

        // Optional: Role validation
        validateMessagingPermission(sender, receiver);

        Message message = new Message();
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setContent(content);
        message.setTimestamp(LocalDateTime.now());
        message.setReadStatus(false);

        return messageRepository.save(message);
    }

    //  Get full conversation
    public List<Message> getConversation(String email1, String email2) {

        User user1 = userRepository.findByEmail(email1)
                .orElseThrow(() -> new RuntimeException("User not found"));

        User user2 = userRepository.findByEmail(email2)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return messageRepository.findConversation(
                user1.getId(),
                user2.getId()
        );
    }

    // Get unread messages
    public List<Message> getUnreadMessages(String receiverEmail) {

        User receiver = userRepository.findByEmail(receiverEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return messageRepository.findByReceiverAndReadStatusFalse(receiver);
    }

    // Mark messages as read
    public void markAsRead(Long messageId) {

        Message message = messageRepository.findById(messageId)
                .orElseThrow(() -> new RuntimeException("Message not found"));

        message.setReadStatus(true);
    }

    //  Role-based restriction (Optional)
    private void validateMessagingPermission(User sender, User receiver) {

        if (sender.getRole() == Role.STUDENT &&
                receiver.getRole() == Role.STUDENT) {
            throw new RuntimeException("Students cannot message students");
        }

        // You can extend rules here
    }
}