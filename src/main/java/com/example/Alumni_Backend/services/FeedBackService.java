package com.example.Alumni_Backend.services;

import com.example.Alumni_Backend.DTO.FeedBackDTO;
import com.example.Alumni_Backend.DTO.SuggestionsDTO;
import com.example.Alumni_Backend.models.Feedback;
import com.example.Alumni_Backend.models.Suggestions;

import java.util.List;


public interface FeedBackService {

    Feedback submitFeedBack(FeedBackDTO feedBackDTO);
    Suggestions suggest(SuggestionsDTO suggestionsDTO);
    List<Suggestions> getSuggestions();
//    List<Suggestions> getSuggestion(String email);
}
