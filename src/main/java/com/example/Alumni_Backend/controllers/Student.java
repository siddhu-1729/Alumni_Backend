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
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
//imports for profile picture upload
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.HttpEntity;
import org.springframework.web.multipart.MultipartFile;

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

    @PutMapping("/{id}/update")
    ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
        User updatedUser=userService.updateUser(id,user);
        return ResponseEntity.ok(updatedUser);
    }

//Method to upload profile picture (Converting into Bytes and storing in DB)
    @PostMapping("/profile-picture")
    public ResponseEntity<String> uploadProfilePicture(
            Authentication authentication,
            @RequestParam("file") MultipartFile file) {

        String username = authentication.getName();

        User user = profiles.studentProfileRequest(username);

        userService.uploadProfilePicture(user.getId(), file);

        return ResponseEntity.ok("Profile picture uploaded successfully.");
    }

//Getting profile picture(reconstructing images from bytes stored in DB)
    @GetMapping("/profile-picture")
    public ResponseEntity<byte[]> getProfilePicture(Authentication authentication) {

        String username = authentication.getName();

        User user = profiles.studentProfileRequest(username);

        byte[] image = userService.getProfilePicture(user.getId());

        if (image == null) {
            return ResponseEntity.notFound().build();
        }

        String type = userService.getProfilePictureType(user.getId());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, type)
                .body(image);
    }
//Deleting profile picture (marks the space as null)
    @DeleteMapping("/profile-picture")
    public ResponseEntity<String> deleteProfilePicture(Authentication authentication) {

        String username = authentication.getName();

        User user = profiles.studentProfileRequest(username);

        userService.deleteProfilePicture(user.getId());

        return ResponseEntity.ok("Profile picture removed.");
    }
}
