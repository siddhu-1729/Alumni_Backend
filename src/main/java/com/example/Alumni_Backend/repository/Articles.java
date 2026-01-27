package com.example.Alumni_Backend.repository;

import com.example.Alumni_Backend.models.SuccessStories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Articles extends JpaRepository<SuccessStories,Long> {
}
