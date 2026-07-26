package com.example.Alumni_Backend.controllers;


import com.example.Alumni_Backend.DTO.ArticleRequest;
import com.example.Alumni_Backend.DTO.FeedBackDTO;
import com.example.Alumni_Backend.DTO.JobRequest;
import com.example.Alumni_Backend.models.Feedback;
import com.example.Alumni_Backend.models.Jobs;
import com.example.Alumni_Backend.models.SuccessStories;
import com.example.Alumni_Backend.models.User;
import com.example.Alumni_Backend.services.FeedBackService;
import com.example.Alumni_Backend.services.JOBService;
import com.example.Alumni_Backend.services.Profiles;
import com.example.Alumni_Backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alumni")
public class Alumni {

    @Autowired
    UserService userService;

    @Autowired
    Profiles profiles;

    @GetMapping
    public User alumniProfileRequest(Authentication auth){
        String username= auth.getName();
        return profiles.alumniProfileRequest(username);
    }

    @GetMapping("/all")
    public List<User> hello(){
        return userService.getAlumni();
    }

    @GetMapping("/data")
    public UserDetails get(@RequestBody String username){

        return userService.userDetailsService().loadUserByUsername(username);
    }
    @PostMapping("/share_story")
    public SuccessStories postStory(@RequestBody ArticleRequest articleRequest){
       return  userService.successStories(articleRequest);
    }
    @GetMapping("/getStory")
    public List<SuccessStories> getStory(){
        return userService.getStories();
    }

    @Autowired
    private FeedBackService feedBackService;
    @PostMapping("/submit_feedback")
    public Feedback submit(@RequestBody FeedBackDTO feedBackDTO){
        return feedBackService.submitFeedBack(feedBackDTO);
    }

    @PutMapping("/{id}/update")
     ResponseEntity<User> update(@PathVariable Long id,@RequestBody User user){
        User updatedUser=userService.updateUser(id,user);
        return ResponseEntity.ok(updatedUser);
    }
//    uploading profile picture to DB
    @PostMapping("/profile-picture")
    public ResponseEntity<String> uploadProfile(Authentication authentication, @RequestParam("file")MultipartFile multipartFile){
        String name= authentication.getName();
        User user=profiles.alumniProfileRequest(name);

        userService.uploadProfilePicture(user.getId(),multipartFile);

      return ResponseEntity.ok("Profile picture uploaded successfully");
    }

// loading profile picture from DB
    @GetMapping("/profile-picture")
   public ResponseEntity<byte[]> getProfilePicture(Authentication authentication){
        String name=authentication.getName();

        User user=profiles.alumniProfileRequest(name);
        byte[] image= userService.getProfilePicture(user.getId());

        if(image==null){
            return ResponseEntity.notFound().build();
        }
        String type= userService.getProfilePictureType(user.getId());
//        based on the type it will send the image to client.
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE,type).body(image);
   }

   @DeleteMapping("/profile-picture")
   public ResponseEntity<String> deleteprofile(Authentication authentication){
        String name = authentication.getName();
        User user=profiles.alumniProfileRequest(name);
        userService.deleteProfilePicture(user.getId());
        return ResponseEntity.ok("Profile picture is successfully deleted");
   }
}
