package com.example.Alumni_Backend.controllers;

import com.example.Alumni_Backend.DTO.JobRequest;
import com.example.Alumni_Backend.models.Jobs;
import com.example.Alumni_Backend.services.JOBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Jobs")
public class JobsController {

    @Autowired
    private JOBService jobService;

    @PostMapping("/addjob")
    public Jobs addJob(@RequestBody JobRequest jobRequest){
        return jobService.addJob(jobRequest);
    }

    @GetMapping("/")
    public List<Jobs> findallJobs(){
        return jobService.getJobsData();
    }
}
