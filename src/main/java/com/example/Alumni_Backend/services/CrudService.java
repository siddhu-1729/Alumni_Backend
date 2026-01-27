package com.example.Alumni_Backend.services;

import com.example.Alumni_Backend.models.Events;
import com.example.Alumni_Backend.models.User;
import org.springframework.http.ResponseEntity;

public interface CrudService {

     ResponseEntity<?> delAlumni(Long id);
     ResponseEntity<?> delStudent(Long id);
     ResponseEntity<?> delStaff(Long id);
}
