package com.example.Alumni_Backend.services;

import com.example.Alumni_Backend.DTO.EventRequest;
import com.example.Alumni_Backend.models.Events;

import java.util.List;

public interface EventService {
    public Events addEvent(EventRequest eventRequest);
    public Events getEvent(Long id);
    public List<Events> getEvent();
}
