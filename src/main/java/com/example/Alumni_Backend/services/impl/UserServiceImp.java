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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.io.IOException;
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
                return userRepo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User not Found"));
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
    public Optional<User> getById(Long id){
        return userRepo.findById(id);
    }

    public List<SuccessStories> getStories(){
        return articles.findAll();
    }

    public User updateUser(Long id,User user){
//        No need to setRole() , it will be automatically settled while signing up
        User existedUser=userRepo.findById(id).orElseThrow(()->new RuntimeException("User Not Found"));
        existedUser.setFullname(user.getFullname());
        existedUser.setGithub(user.getGithub());
        existedUser.setLinkedIn(user.getLinkedIn());

        existedUser.setBranch(user.getBranch());
        existedUser.setUsername(user.getUsername());
        existedUser.setYearofpassing(user.getYearofpassing());
        existedUser.setMobilenumber(user.getMobilenumber());
        existedUser.setInterests(user.getInterests());
        existedUser.setJobrole(user.getJobrole());
        existedUser.setCollegeID(user.getCollegeID());
        existedUser.setEmail(user.getEmail());
        existedUser.setLocation(user.getLocation());
        return userRepo.save(existedUser);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public void uploadProfilePicture(Long userId, MultipartFile file) {
             User user=userRepo.findById(userId).orElseThrow(()->new RuntimeException("User not Found"));

             if(file.isEmpty()){
                 throw new RuntimeException("Please select image");
             }

             if(file.getSize()>5*1024*1024){
                 throw new RuntimeException("Image size should exceed 5MB");
             }

             String contentType=file.getContentType();
        System.out.println("content Type: "+contentType);

             if(contentType==null|| !(contentType.equals("image/jpeg")
                     || contentType.equals("image/png")||contentType.equals("image/webp"))){
                 throw new RuntimeException("Only JPEG , PNG and WEBP images are allowed");
             }

             try{
                 user.setProfilePicture(file.getBytes());
                 user.setProfilePictureName(file.getName());
                 user.setProfilePictureSize(file.getSize());
                 user.setProfilePictureType(file.getContentType());

                 userRepo.save(user);
             }catch (IOException e){
                 throw new RuntimeException("Failed to upload");
             }
    }

    @Override
    public byte[] getProfilePicture(Long userId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return user.getProfilePicture();
    }

    @Override
    public String getProfilePictureType(Long userId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return user.getProfilePictureType();
    }

    @Override
    public void deleteProfilePicture(Long userId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setProfilePicture(null);
        user.setProfilePictureName(null);
        user.setProfilePictureType(null);
        user.setProfilePictureSize(null);

        userRepo.save(user);
    }
}
