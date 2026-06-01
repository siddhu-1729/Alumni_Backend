package com.example.Alumni_Backend.services.MessagingServices;


import com.example.Alumni_Backend.DTO.MessageRequest;
import com.example.Alumni_Backend.DTO.MessageResponse;
import com.example.Alumni_Backend.models.Messaging.Message;
import com.example.Alumni_Backend.repository.MessagingRepos.MessageRepo;
import com.example.Alumni_Backend.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service

public class MessageServiceImp implements MessageService {

    private final MessageRepo messageRepository;


    public MessageServiceImp(MessageRepo messageRepository) {
        this.messageRepository = messageRepository;
    }

    public MessageResponse saveAndBuild(
            String sender,
            MessageRequest request) {

        Message message = new Message();

        message.setSender(sender);
        message.setReceiver(request.getReceiver());
        message.setContent(request.getContent());
        message.setTimestamp(LocalDateTime.now());

        messageRepository.save(message);

        return map(message);
    }

    private MessageResponse map(Message message){
        MessageResponse response=new MessageResponse();

        response.setContent(message.getContent());
        response.setReceiver(message.getReceiver());
        response.setSender(message.getSender());
        response.setTimestamp(message.getTimestamp());

        return response;
    }
}