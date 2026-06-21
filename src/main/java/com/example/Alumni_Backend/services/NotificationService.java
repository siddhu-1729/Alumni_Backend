package com.example.Alumni_Backend.services;

import com.example.Alumni_Backend.DTO.ConnectNotificationDto;



public interface NotificationService {

     boolean notifyAlumni(String studentName, Long id);
}
