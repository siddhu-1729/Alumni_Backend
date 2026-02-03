package com.example.Alumni_Backend.services.impl;

//import com.example.Alumni_Backend.DTO.StudentProfileRequest;
import com.example.Alumni_Backend.DTO.ArticleRequest;
import com.example.Alumni_Backend.models.Role;
import com.example.Alumni_Backend.models.SuccessStories;
import com.example.Alumni_Backend.models.User;
import com.example.Alumni_Backend.repository.Articles;
import com.example.Alumni_Backend.repository.UserRepo;
import com.example.Alumni_Backend.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

//File to handle the UserDetails and Users interactions such as articles posted and stories that has shared

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

    @Autowired
    private Articles articles;

    public SuccessStories successStories(ArticleRequest articleRequest){
        SuccessStories successStories= new SuccessStories();
        successStories.setAuthor(articleRequest.getAuthor());
        successStories.setContent(articleRequest.getContent());
        successStories.setCreatedAt(articleRequest.getTime());
        successStories.setTitle(articleRequest.getTitle());
       return articles.save(successStories);
    }
    public User getById(Long id){
        return getById(id);
    }

    public List<SuccessStories> getStories(){
        return articles.findAll();
    }
}
