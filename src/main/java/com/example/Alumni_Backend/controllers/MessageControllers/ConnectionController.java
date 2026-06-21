package com.example.Alumni_Backend.controllers.MessageControllers;

import com.example.Alumni_Backend.DTO.ConnectNotificationDto;
import com.example.Alumni_Backend.models.User;
import com.example.Alumni_Backend.services.NotificationService;
import com.example.Alumni_Backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/api/connections")
public class ConnectionController {
//SimpMessagingTemplate ---> sever-side sender for Websocket messaging through STOMP

    @Autowired
    private NotificationService notificationService;
    @Autowired
    private UserService userService;

//  Notifications , when a user clicks on connect button! instantly alumni will be notified about the Connection.
// principal --> currently authenticated user (by using .getName() we can read the username.
// Saving each message that has been carried out.
// sends message to specified user through STOMP
   @PostMapping("{alumniId}")
    public ResponseEntity<String> connectWithAlumni(@PathVariable Long alumniId,Principal principal){
       if(principal==null){
           return ResponseEntity.status(401).body("User not Authenticated");
       }

     boolean sent=notificationService.notifyAlumni(principal.getName(),alumniId);

       if(!sent){
           return ResponseEntity.status(404).body("Student or Alumni not found");
       }

       return ResponseEntity.ok("Connection Request Sent");
    }
}
