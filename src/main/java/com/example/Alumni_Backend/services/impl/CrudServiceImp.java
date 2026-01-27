package com.example.Alumni_Backend.services.impl;

import com.example.Alumni_Backend.repository.UserRepo;
import com.example.Alumni_Backend.services.CrudService;
import jakarta.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CrudServiceImp implements CrudService {
 //file for admin to manage users in the application
    private final UserRepo userRepo;

    public CrudServiceImp(UserRepo userRepo) {
        this.userRepo = userRepo;
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
}
