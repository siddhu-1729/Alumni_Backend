package com.example.Alumni_Backend.services.MessagingServices;

import com.example.Alumni_Backend.DTO.ConnectNotificationDto;
import com.example.Alumni_Backend.models.User;
import com.example.Alumni_Backend.services.NotificationService;

import com.example.Alumni_Backend.services.UserService;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class NotificationServiceImp implements NotificationService {

   private final SimpMessagingTemplate simpMessagingTemplate;
   private final UserService userService;
   private final UserSocketTrackerService userSocketTrackerService;
//Constructor Injection
    public NotificationServiceImp(SimpMessagingTemplate simpMessagingTemplate, UserService userService, UserSocketTrackerService userSocketTrackerService) {

        this.simpMessagingTemplate = simpMessagingTemplate;
        this.userService=userService;
        this.userSocketTrackerService = userSocketTrackerService;
    }

//Notifications to alumni connections
    public boolean notifyAlumni(String Studentname,Long alumniId){
        Optional<User> studentOpt=userService.findByUsername(Studentname);
        Optional<User> alumniOpt=userService.getById(alumniId);
         if(studentOpt.isEmpty() || alumniOpt.isEmpty())
              return false;
         User student=studentOpt.get();
         User alumni=alumniOpt.get();

         // Check Whether the both the parties are connected to Socket or Not
        boolean studentConnected= userSocketTrackerService.isUserConnected(Studentname);
        boolean alumniConnected= userSocketTrackerService.isUserConnected(alumni.getUsername());

        //Checking Whether the users are Connected to the socket session or not
        System.out.println("Connected Users to Socket");
        System.out.println(Studentname+" : "+studentConnected);
        System.out.println(alumni.getUsername()+":"+alumniConnected);

         ConnectNotificationDto connectNotificationDto=new ConnectNotificationDto(student.getId(), student.getFullname(), student.getFullname()+"Sent you a connection request","Connection_Request");
//        simpMessagingTemplate.convertAndSendToUser(alumni.getUsername(),"/queue/notifications",connectNotificationDto);
        //convertAndSend works for broadcasts messages and opened socket connection. It wouldn't be a user specific ,authenticated connected communication
         simpMessagingTemplate.convertAndSend("/topic/test",connectNotificationDto);
        System.out.println("Alumni has been notified");
        return true;
    }

}