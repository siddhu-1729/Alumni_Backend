package com.example.Alumni_Backend.services;

import com.example.Alumni_Backend.DTO.MessageRequest;
import com.example.Alumni_Backend.DTO.MessageResponse;
import com.example.Alumni_Backend.models.Messaging.Message;
import com.example.Alumni_Backend.models.User;

public interface MessageService {

    public MessageResponse saveAndBuild(
            String sender,
            MessageRequest request);
}
