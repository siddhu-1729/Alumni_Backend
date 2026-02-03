//package com.example.Alumni_Backend.services.MessagingServices;
//
//
//import com.example.Alumni_Backend.models.Messaging.Conversation;
//import com.example.Alumni_Backend.models.Messaging.Message;
//import com.example.Alumni_Backend.models.User;
//import com.example.Alumni_Backend.repository.MessagingRepos.MessageRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MessageService {
//    @Autowired
//    private MessageRepo messageRepo;
//    @Autowired
//    private ConversationService conversationService;
//
//    public Message send(User sender, User receiver, String content) {
//
//        // role validation
//        if (sender.getRole().equals(receiver.getRole())) {
//            throw new RuntimeException("Invalid messaging");
//        }
//
//        User student = sender.getRole().equals("STUDENT") ? sender : receiver;
//        User alumni  = sender.getRole().equals("ALUMNI")  ? sender : receiver;
//
//        Conversation conversation =
//                conversationService.getOrCreate(student, alumni);
//
//        Message msg = new Message();
//        msg.setConversation(conversation);
//        msg.setSender(sender);
//        msg.setReceiver(receiver);
//        msg.setContent(content);
//
//        return messageRepo.save(msg);
//    }
//}
