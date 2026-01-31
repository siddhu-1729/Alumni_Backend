package com.example.Alumni_Backend.services;

import com.example.Alumni_Backend.DTO.ArticleRequest;
import com.example.Alumni_Backend.models.SuccessStories;
import com.example.Alumni_Backend.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService{

    //File to handle the UserDetails and Users interactions such as articles posted and stories that has shared

    UserDetailsService userDetailsService();

    List<User> getAdmin();
    List<User> getAlumni();
    List<User> getStudent();
    List<User> getStaff();
     User getById(Long id);
    SuccessStories successStories(ArticleRequest articleRequest);
    List<SuccessStories> getStories();
}
