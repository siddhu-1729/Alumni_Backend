package com.example.Alumni_Backend.DTO;

import java.time.LocalDateTime;

public class MessageResponse {

    private String sender;

    private String receiver;

    private String content;

    private LocalDateTime timestamp;

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
