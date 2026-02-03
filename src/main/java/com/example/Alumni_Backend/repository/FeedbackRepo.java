package com.example.Alumni_Backend.repository;

import com.example.Alumni_Backend.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepo extends JpaRepository<Feedback,Long> {
}
