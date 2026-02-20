package com.example.Alumni_Backend.services;

import com.example.Alumni_Backend.models.Messaging.Message;
import com.example.Alumni_Backend.models.User;

public interface MessageService {

    public Message save(User sender, User receiver, String content);
}
