package com.example.Alumni_Backend.services.impl;

import com.example.Alumni_Backend.DTO.JWTAuthenticationResponse;
import com.example.Alumni_Backend.DTO.RefreshTokenRequest;
import com.example.Alumni_Backend.DTO.SigninRequest;
import com.example.Alumni_Backend.DTO.SignupRequest;
import com.example.Alumni_Backend.models.Role;
import com.example.Alumni_Backend.models.User;
import com.example.Alumni_Backend.repository.UserRepo;
import com.example.Alumni_Backend.services.AuthenticationService;
import com.example.Alumni_Backend.services.JWTService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AuthenticationServiceImp implements AuthenticationService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    private final JWTService jwtService;

    public AuthenticationServiceImp(UserRepo userRepo, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JWTService jwtService) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public User staffsignup(SignupRequest signupRequest){
       User user=new User();
       user.setUsername(signupRequest.getUsername());
       user.setEmail(signupRequest.getEmail());
       user.setJobrole(signupRequest.getJobrole());
       user.setCollegeID(signupRequest.getCollegeID());
       user.setWorkingcompany(signupRequest.getWorkingcompany());
       user.setYearofpassing(signupRequest.getYearofpassing());
       user.setMobilenumber(signupRequest.getMobilenumber());
       user.setInterests(signupRequest.getInterests());
       user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
       user.setRole(Role.STAFF);
       user.setBranch(signupRequest.getBranch());
      return userRepo.save(user);
    }

    public User studentsignup(SignupRequest signupRequest){
        User user=new User();
        user.setEmail(signupRequest.getEmail());
        user.setJobrole(signupRequest.getJobrole());
        user.setCollegeID(signupRequest.getCollegeID());
//        user.setWorkingcompany(signupRequest.getWorkingcompany());
        user.setUsername(signupRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setMobilenumber(signupRequest.getMobilenumber());
        user.setYearofpassing(signupRequest.getYearofpassing());
        user.setRole(Role.STUDENT);
        user.setInterests(signupRequest.getInterests());
        user.setBranch(signupRequest.getBranch());
        user.setFullname(signupRequest.getFullname());
        return userRepo.save(user);
    }

    public User alumnisignup(SignupRequest signupRequest){
        User user=new User();
        user.setEmail(signupRequest.getEmail());
        user.setCollegeID(signupRequest.getCollegeID());
        user.setJobrole(signupRequest.getJobrole());
        user.setInterests(signupRequest.getInterests());
        user.setWorkingcompany(signupRequest.getWorkingcompany());
        user.setUsername(signupRequest.getUsername());
        user.setMobilenumber(signupRequest.getMobilenumber());
        user.setYearofpassing(signupRequest.getYearofpassing());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setRole(Role.ALUMNI);
        user.setBranch(signupRequest.getBranch());
        return userRepo.save(user);
    }

    public JWTAuthenticationResponse signin(SigninRequest signinRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getUsername(),signinRequest.getPassword()));
        var user=userRepo.findByUsername(signinRequest.getUsername()).orElseThrow(() -> new IllegalArgumentException("invalid user"));
        var jwt=jwtService.generateToken(user);
        var refreshToken=jwtService.generateRefreshToken(new HashMap<>(),user);

        JWTAuthenticationResponse jwtAuthenticationResponse=new JWTAuthenticationResponse();
        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshToken);
        return jwtAuthenticationResponse;
    }

    public JWTAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest){
        String userName=jwtService.extractUsername(refreshTokenRequest.getToken());
        User user=userRepo.findByUsername(userName).orElseThrow();
        if(jwtService.isTokenValid(refreshTokenRequest.getToken(), user)){
            var jwt=jwtService.generateToken(user);
            JWTAuthenticationResponse jwtAuthenticationResponse=new JWTAuthenticationResponse();
            jwtAuthenticationResponse.setToken(jwt);
            jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());
            return jwtAuthenticationResponse;
        }
        return null;
    }

    public List<String> allEmails(){
     return userRepo.findAllEmails();
//        return "Email has been sent";
    }
    @Autowired
   private JavaMailSender javaMailSender;

    public String sendEmailUpdates() throws MessagingException {
//        List<String> emails=allEmails();
//        for(String email:emails){
//            SimpleMailMessage msg= new SimpleMailMessage();
//            msg.setFrom("lettertosiddhardha@gmail.com");
//            msg.setSubject("A sample email");
//            msg.setText("This a sample email dude's");
////           if(email!=null)
//                msg.setTo(email);
////            msg.setTo(emails.toArray(new String[0]));
//            javaMailSender.send(msg);
//        }
        List<String> emails=allEmails().stream().filter(e->e!=null &&!e.isBlank() &&e.contains("@")).toList();
        for(String email:emails){

            MimeMessage msg=javaMailSender.createMimeMessage();
            MimeMessageHelper helper=new MimeMessageHelper(msg,true,"UTF-8");

            helper.setFrom("lettertosiddhardha@gmail.com");
            helper.setTo(email);
            helper.setSubject("A mail Regarding Current Happening Events in Our Campus");

            String content="""
            <html>
                <body>
                    <h2 style="color:blue;">Hello!</h2>
                    <p>This is an <b>email</b> sent from Our Organisation.</p>
                    <p>Regards,<br/>Alumni Team</p>
                </body>
            </html>
        """;

            helper.setText(content,true);
            try {
                javaMailSender.send(msg);
                System.out.println("Email sent to :" + email);
            }catch (Exception e){
                System.out.println("Exception in sending Email");
                e.printStackTrace();
            }
        }

        return "emails have been sent";
    }
}
