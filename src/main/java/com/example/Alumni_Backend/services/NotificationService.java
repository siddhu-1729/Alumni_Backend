package com.example.Alumni_Backend.services;

import com.example.Alumni_Backend.DTO.ConnectNotificationDto;



public interface NotificationService {

     void notifyAlumni(String alumniName, ConnectNotificationDto connectNotificationDto);
}
