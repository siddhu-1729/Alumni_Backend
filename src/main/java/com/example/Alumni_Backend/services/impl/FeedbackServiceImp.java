package com.example.Alumni_Backend.services.impl;

import com.example.Alumni_Backend.DTO.FeedBackDTO;
import com.example.Alumni_Backend.models.Feedback;
import com.example.Alumni_Backend.repository.FeedbackRepo;
import com.example.Alumni_Backend.services.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImp implements FeedBackService {
    @Autowired
    private FeedbackRepo feedbackRepo;

    public Feedback submitFeedBack(FeedBackDTO feedBackDTO){
        Feedback feedback=new Feedback();
        feedback.setRating(feedBackDTO.getRating());
        feedback.setContent(feedBackDTO.getContent());
        feedback.setComments(feedBackDTO.getComments());
        feedback.setCourse_material(feedBackDTO.getCourse_material());
        feedback.setRecommendation(feedBackDTO.getRecommendation());
        feedback.setInstructor_rating(feedback.getInstructor_rating());
        return feedbackRepo.save(feedback);
    }
}
