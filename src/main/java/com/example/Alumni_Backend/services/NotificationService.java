package com.example.Alumni_Backend.services;

import com.example.Alumni_Backend.DTO.MessageDTO;


public interface NotificationService {

     boolean notifyAlumni(String studentName, Long id);
//     boolean sendMessage(MessageDTO messageDTO);
}
