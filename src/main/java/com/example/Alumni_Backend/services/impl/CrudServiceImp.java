package com.example.Alumni_Backend.services.impl;

import com.example.Alumni_Backend.models.Events;
import com.example.Alumni_Backend.repository.EventRepo;
import com.example.Alumni_Backend.repository.UserRepo;
import com.example.Alumni_Backend.services.CrudService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CrudServiceImp implements CrudService {
     @Autowired
    private final UserRepo userRepo;

     private final EventRepo eventRepo;

    public CrudServiceImp(UserRepo userRepo, EventRepo eventRepo) {
        this.userRepo = userRepo;
        this.eventRepo = eventRepo;
    }

    public ResponseEntity<?> delAlumni(Long id) {
        if (!userRepo.existsById(id)) {
            return ResponseEntity.badRequest().body("Alumni not found");
        }
        userRepo.deleteById(id);
        return ResponseEntity.ok("Alumni data deleted. Cannot be undone.");
    }

    public ResponseEntity<?> delStudent(Long id) {
        if (!userRepo.existsById(id)) {
            return ResponseEntity.badRequest().body("Student not found");
        }
        userRepo.deleteById(id);
        return ResponseEntity.ok("Student record deleted. Cannot be undone.");
    }

    public ResponseEntity<?> delStaff(Long id) {
        if (!userRepo.existsById(id)) {
            return ResponseEntity.badRequest().body("Staff not found");
        }
        userRepo.deleteById(id);
        return ResponseEntity.ok("Staff data deleted. Cannot be undone.");
    }

    public Events addEvent(Events event){
        System.out.println("Event has been added to Database");
        return eventRepo.save(event);
    }
}
