package com.example.Alumni_Backend.services;

import com.example.Alumni_Backend.DTO.ArticleRequest;
import com.example.Alumni_Backend.models.SuccessStories;
import com.example.Alumni_Backend.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Optional;


public interface UserService{

    //File to handle the UserDetails and Users interactions such as articles posted and stories that has shared

    UserDetailsService userDetailsService();

    List<User> getAdmin();
    List<User> getAlumni();
    List<User> getStudent();
    List<User> getStaff();
    Optional<User> getById(Long id);
    SuccessStories successStories(ArticleRequest articleRequest);
    List<SuccessStories> getStories();

    User updateUser(Long id,User user);

    Optional<User> findByUsername(String username);

    //Profile picture upload and store it in Postgres DB for Version.1
    void uploadProfilePicture(Long userId, MultipartFile file);

    byte[] getProfilePicture(Long userId);

    String getProfilePictureType(Long userId);

    void deleteProfilePicture(Long userId);
}
