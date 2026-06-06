package com.example.Alumni_Backend.controllers.ChatControllers;

import com.example.Alumni_Backend.DTO.MessageRequest;
import com.example.Alumni_Backend.DTO.MessageResponse;
import com.example.Alumni_Backend.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private MessageService messageService;

    @SendTo("/topic/messages")
   @MessageMapping("/app/chat.send")
    public void sendMesaage(MessageRequest messageRequest, Principal principal){
          String sender= principal.getName();

        MessageResponse messageResponse=messageService.saveAndBuild(sender,messageRequest);

        simpMessagingTemplate.convertAndSendToUser(messageRequest.getReceiver(),"/queue/messages",messageResponse);
    }
}
