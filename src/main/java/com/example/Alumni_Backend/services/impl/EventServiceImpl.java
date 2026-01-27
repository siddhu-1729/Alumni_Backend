package com.example.Alumni_Backend.services.impl;

import com.example.Alumni_Backend.DTO.EventRequest;
import com.example.Alumni_Backend.models.Events;
import com.example.Alumni_Backend.repository.EventRepo;
import com.example.Alumni_Backend.services.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//File to handle the events in the application


@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepo eventRepo;

    public Events addEvent(EventRequest eventRequest){
        Events event=new Events();
        event.setEventName(eventRequest.getEventname());
        event.setEventDescription(eventRequest.getDescription());
        event.setImage(eventRequest.getImage());
       return eventRepo.save(event);
    }

    public Events getEvent(Long id){
        return eventRepo.findById(id).orElseThrow(()->new UsernameNotFoundException("Event not found"));
    }

    public List<Events> getEvent(){
        return eventRepo.findAll();
    }
}
