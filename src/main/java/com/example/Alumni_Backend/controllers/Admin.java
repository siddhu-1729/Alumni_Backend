package com.example.Alumni_Backend.controllers;

import com.example.Alumni_Backend.DTO.EventRequest;
import com.example.Alumni_Backend.DTO.SignupRequest;
import com.example.Alumni_Backend.models.Events;
import com.example.Alumni_Backend.models.User;
import com.example.Alumni_Backend.services.CrudService;
import com.example.Alumni_Backend.services.EventService;
import com.example.Alumni_Backend.services.Profiles;
import com.example.Alumni_Backend.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/api/v1/admin")
public class Admin {
    @Autowired
    private EventService eventService;
    @Autowired
    CrudService crudService;
    @Autowired
    UserService userService;
    @Autowired
    Authentications authentications;
    @Autowired
    Profiles profiles;

    @GetMapping
    public User adminProfileRequest(Authentication auth){
        String username=auth.getName();
        return profiles.adminProfileRequest(username);
    }

    @GetMapping("/all")
    public List<User> hello(){
        return userService.getAdmin();
    }


    //Deleting the candidates (student,alumni,staff)
    @PostMapping("/delalumni")
    public ResponseEntity<?> delAlumni(@RequestBody User user){
        Long id=user.getId();
       return  crudService.delAlumni(id);
    }
    @PostMapping("/delstudent")
    public ResponseEntity<?> delStudent(@RequestBody User student){
        return crudService.delStudent(student.getId());
    }
    @PostMapping("/delstaff")
    public ResponseEntity<?> delStaff(@RequestBody User staff){
        return crudService.delStaff(staff.getId());
    }


    // Adding events
    @PostMapping("/addEvent")
    public Events addEvent(@RequestBody EventRequest event){
        return eventService.addEvent(event);
    }

    //Adding users (staff,alumni ,student)
    @PostMapping("/addAlumni")
    public ResponseEntity<User> addAlumni(@RequestBody SignupRequest signupRequest){
        return authentications.alumnisignup(signupRequest);
    }
    @PostMapping("/addStaff")
    public ResponseEntity<User> addStaff(@RequestBody SignupRequest signupRequest){
        return authentications.staffsignup(signupRequest);
    }
    @PostMapping("/addStudent")
    public ResponseEntity<User> addStudent(@RequestBody SignupRequest signupRequest){
        return authentications.studentsignup(signupRequest);
    }

}
