package com.example.Alumni_Backend.services;

import com.example.Alumni_Backend.DTO.JobRequest;
import com.example.Alumni_Backend.models.Jobs;

import java.util.List;

public interface JOBService {

    List<Jobs> getJobsData();
    Jobs getJobById(Long id);
     Jobs addJob(JobRequest jobRequest);
}
