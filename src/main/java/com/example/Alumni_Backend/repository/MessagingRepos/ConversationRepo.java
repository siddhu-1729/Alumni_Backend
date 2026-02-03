//package com.example.Alumni_Backend.repository.MessagingRepos;
//
//import com.example.Alumni_Backend.models.Messaging.Conversation;
//import com.example.Alumni_Backend.models.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface ConversationRepo extends JpaRepository<Conversation,Long> {
//
//    Optional<Conversation> findByStudentAndAlumni(User student,User alumni);
//    List<Conversation> findByStudentOrAlumni(User student, User alumni);
//}
