package com.example.Alumni_Backend.services.impl;

//import com.example.Alumni_Backend.DTO.StudentProfileRequest;
import com.example.Alumni_Backend.models.Role;
import com.example.Alumni_Backend.models.User;
import com.example.Alumni_Backend.repository.UserRepo;
import com.example.Alumni_Backend.services.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserRepo userRepo;

    public UserServiceImp(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetailsService userDetailsService(){
        return new UserDetailsService(){
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("username not found"));
            }
        };
    }

    public List<User> getAdmin(){
        
        return userRepo.findByRole(Role.ADMIN);
    }

    public List<User> getAlumni(){
        return  userRepo.findByRole(Role.ALUMNI);
    }

    public List<User> getStudent(){
        return userRepo.findByRole(Role.STUDENT);
    }

    public List<User> getStaff(){
        return userRepo.findByRole(Role.STAFF);
    }

//    public ResponseEntity<?> studentProfileRequest(){
//        return userRepo.
//    }
}
