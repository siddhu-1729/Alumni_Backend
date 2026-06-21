package com.example.Alumni_Backend.models.Messaging;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Notification {

    private String message;

    public Notification(String message){
        this.message=message;
    }

}
