package com.example.Alumni_Backend.repository;

import com.example.Alumni_Backend.models.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepo extends JpaRepository<Events, Long> {

}
