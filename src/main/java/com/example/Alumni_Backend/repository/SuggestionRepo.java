package com.example.Alumni_Backend.repository;

import com.example.Alumni_Backend.models.Suggestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SuggestionRepo extends JpaRepository<Suggestions,Long> {
    List<Suggestions> findAll();
//    List<Suggestions> findByEmail(String email);
}
