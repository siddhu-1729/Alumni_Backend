package com.example.Alumni_Backend.services;

import com.example.Alumni_Backend.DTO.FeedBackDTO;
import com.example.Alumni_Backend.models.Feedback;



public interface FeedBackService {

    Feedback submitFeedBack(FeedBackDTO feedBackDTO);
}
