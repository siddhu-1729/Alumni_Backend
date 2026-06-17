package com.example.Alumni_Backend.controllers.MessageControllers;

import com.example.Alumni_Backend.DTO.ConnectNotificationDto;
import com.example.Alumni_Backend.models.User;
import com.example.Alumni_Backend.services.NotificationService;
import com.example.Alumni_Backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/api/connections")
public class ConnectionController {
//SimpMessagingTemplate ---> sever-side sender for Websocket messaging through STOMP
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
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
       Optional<User> student=userService.findByUsername(principal.getName());
        User alumni=userService.getById(alumniId);

        // Handling the edge cases
        if(student.isPresent()){
            User user=student.get();

            ConnectNotificationDto connectNotificationDto=new ConnectNotificationDto(user.getId(),
                    user.getFullname(), user.getFullname() +"Sent you a connection request",
                    "CONNECTION REQUEST");
            notificationService.notifyAlumni(alumni.getUsername(),connectNotificationDto);
        }

       return ResponseEntity.ok("Connection Request Sent");
    }
}
