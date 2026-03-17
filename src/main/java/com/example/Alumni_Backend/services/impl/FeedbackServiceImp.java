package com.example.Alumni_Backend.services.impl;

import com.example.Alumni_Backend.DTO.FeedBackDTO;
import com.example.Alumni_Backend.DTO.SuggestionsDTO;
import com.example.Alumni_Backend.models.Feedback;
import com.example.Alumni_Backend.models.Suggestions;
import com.example.Alumni_Backend.repository.FeedbackRepo;
import com.example.Alumni_Backend.repository.SuggestionRepo;
import com.example.Alumni_Backend.services.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
   @Autowired
    private SuggestionRepo suggestionRepo;

    public Suggestions suggest(SuggestionsDTO suggestionsDTO){
        Suggestions suggestions=new Suggestions();
        suggestions.setStudent_name(suggestionsDTO.getStudent_name());
        suggestions.setTitle(suggestionsDTO.getTitle());
        suggestions.setContent(suggestionsDTO.getContent());
        suggestions.setLocalDateTime(suggestionsDTO.getLocalDateTime());
        return suggestionRepo.save(suggestions);

    }
    //Getting all the suggestions that has stored into DataBase
    public List<Suggestions> getSuggestions(){
        return suggestionRepo.findAll();
    }

//   public List<Suggestions> getSuggestion(String email){
//      return suggestionRepo.findByEmail(email);
//    }
}
