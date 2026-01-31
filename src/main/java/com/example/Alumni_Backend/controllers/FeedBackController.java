package com.example.Alumni_Backend.controllers;

import com.example.Alumni_Backend.DTO.FeedBackDTO;
import com.example.Alumni_Backend.models.Feedback;
import com.example.Alumni_Backend.services.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/submit_Feedback")
public class FeedBackController {

    @Autowired
    private FeedBackService feedBackService;

    @PostMapping
    public Feedback submitFeedbackData(@RequestBody FeedBackDTO feedBackDTO){
        return feedBackService.submitFeedBack(feedBackDTO);
    }
}
