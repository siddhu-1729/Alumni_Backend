//package com.example.Alumni_Backend.models.Messaging;
//
//import com.example.Alumni_Backend.models.User;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import jakarta.persistence.*;
//import jakarta.persistence.Table;
//
//import java.time.LocalDateTime;
//
//
//@Entity
//@Table(name = "messages")
//public class Message {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    private Conversation conversation; //one sender and receiver can have multiple conversations
//
//    @ManyToOne  //one sender can send many messages
//    private User sender;
//
//    @ManyToOne //one receiver can receive many messages
//    private User receiver;
//
//    private String content;
//
//    private LocalDateTime sentAt = LocalDateTime.now();
//
//    private boolean read;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Conversation getConversation() {
//        return conversation;
//    }
//
//    public void setConversation(Conversation conversation) {
//        this.conversation = conversation;
//    }
//
//    public User getSender() {
//        return sender;
//    }
//
//    public void setSender(User sender) {
//        this.sender = sender;
//    }
//
//    public User getReceiver() {
//        return receiver;
//    }
//
//    public void setReceiver(User receiver) {
//        this.receiver = receiver;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public LocalDateTime getSentAt() {
//        return sentAt;
//    }
//
//    public void setSentAt(LocalDateTime sentAt) {
//        this.sentAt = sentAt;
//    }
//
//    public boolean isRead() {
//        return read;
//    }
//
//    public void setRead(boolean read) {
//        this.read = read;
//    }
//}
