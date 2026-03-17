package com.example.Alumni_Backend.controllers;

//import com.example.Alumni_Backend.DTO.StudentProfileRequest;
import com.example.Alumni_Backend.DTO.ArticleRequest;
import com.example.Alumni_Backend.DTO.FeedBackDTO;
import com.example.Alumni_Backend.DTO.SuggestionsDTO;
import com.example.Alumni_Backend.models.Feedback;
import com.example.Alumni_Backend.models.SuccessStories;
import com.example.Alumni_Backend.models.Suggestions;
import com.example.Alumni_Backend.models.User;
import com.example.Alumni_Backend.services.FeedBackService;
import com.example.Alumni_Backend.services.Profiles;
import com.example.Alumni_Backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class Student {

    @Autowired
    UserService userService;
    @Autowired
    Profiles profiles;
    @Autowired
    private FeedBackService feedBackService;

    @GetMapping
     public User studentProfileRequest(Authentication authentication){
          String username=authentication.getName();
         return profiles.studentProfileRequest(username);
     }

    @GetMapping("/all")
    public List<User> hello(){
        return userService.getStudent();
    }

    @GetMapping("/data")
    public UserDetails get(@PathVariable String username){
        return userService.userDetailsService().loadUserByUsername(username);
    }

//    @GetMapping("/profile")
//    public StudentProfileRequest studentProfileRequest(){
//        return userService.
//    }

    @PostMapping("/share_story")
    public SuccessStories postStory(@RequestBody ArticleRequest articleRequest){
        return  userService.successStories(articleRequest);
    }

    @GetMapping("/getStory")
    public List<SuccessStories> getStory(){
        return userService.getStories();
    }



    @PostMapping("/submit_feedback")
    public Feedback submit(@RequestBody FeedBackDTO feedBackDTO){
        return feedBackService.submitFeedBack(feedBackDTO);
    }

    @PostMapping("/suggest")
    public Suggestions suggest(SuggestionsDTO suggestionsDTO){
        return feedBackService.suggest(suggestionsDTO);
    }

//    @GetMapping("/{email}")
//   public List<Suggestions> getSuggestion(@PathVariable String email){
//      return feedBackService.getSuggestion(email);
//   }
}
