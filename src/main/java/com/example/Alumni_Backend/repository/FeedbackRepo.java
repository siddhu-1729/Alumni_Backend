package com.example.Alumni_Backend.repository;

import com.example.Alumni_Backend.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback,Long> {
}
