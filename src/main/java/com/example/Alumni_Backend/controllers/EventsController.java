package com.example.Alumni_Backend.controllers;

import com.example.Alumni_Backend.DTO.EventRequest;
import com.example.Alumni_Backend.models.Events;
import com.example.Alumni_Backend.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventsController {
    @Autowired
    private EventService eventService;

    @GetMapping("/")
    public List<Events> getEvents(){
        return eventService.getEvent();
    }

    @GetMapping("/event/{id}")
    public Events getEvent(@PathVariable Long id){
        return eventService.getEvent(id);
    }
    @PostMapping("/addEvent")
    public Events addEvent(@RequestBody EventRequest eventRequest){
       return eventService.addEvent(eventRequest);
    }
}
