package com.example.Alumni_Backend.services.MessagingServices;


import com.example.Alumni_Backend.DTO.ConnectNotificationDto;
import com.example.Alumni_Backend.DTO.MessageResponse;
import com.example.Alumni_Backend.services.NotificationService;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;


@Service
public class NotificationServiceImp implements NotificationService {

   private final SimpMessagingTemplate simpMessagingTemplate;
//Constructor Injection
    public NotificationServiceImp(SimpMessagingTemplate simpMessagingTemplate) {

        this.simpMessagingTemplate = simpMessagingTemplate;
    }

//Notifications to alumni connections
    public void notifyAlumni(String alumniName, ConnectNotificationDto connectNotificationDto){
        simpMessagingTemplate.convertAndSendToUser(alumniName,"/queue/notifications",connectNotificationDto);
        System.out.println("Alumni has been notified");
    }

}