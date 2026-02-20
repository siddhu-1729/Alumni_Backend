package com.example.Alumni_Backend.DTO.MessagingDTOs;

public class ChatMessage {
//    public Long senderId;
//    public Long receiverId;
    String SenderEmail;
    String ReceiverEmail;
     String content;

    public String getSenderEmail() {
        return SenderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        SenderEmail = senderEmail;
    }

    public String getReceiverEmail() {
        return ReceiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        ReceiverEmail = receiverEmail;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
