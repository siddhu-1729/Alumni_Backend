package com.example.Alumni_Backend.DTO;

public class MessageDTO {

    private String sender;
    private String content;

//Empty Constructor, for the ease of creating object and instatiating it.
    public MessageDTO(){}

//    Constructor Injection
    public MessageDTO(String sender,String content){
        this.sender=sender;
        this.content=content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
