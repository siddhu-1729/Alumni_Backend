package com.example.Alumni_Backend.repository;

import com.example.Alumni_Backend.models.Role;
import com.example.Alumni_Backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    List<User> findByRole(Role role);
    @Query("select u.email from User u")   //JPQL Java-persistent Query language. Used in JPA/Hibernate for querying
    //data from Entity(Java classes) and objects
    List<String> findAllEmails();
}
