package com.example.Alumni_Backend.controllers;

import com.example.Alumni_Backend.DTO.JobRequest;
import com.example.Alumni_Backend.models.Jobs;
import com.example.Alumni_Backend.services.JOBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class JobsController {

    @Autowired
    private JOBService jobService;

    @PostMapping({"/alumni/add_job" , "/staff/add_job" ,"/admin/add_job"})
    public Jobs addJob(@RequestBody JobRequest jobRequest){
        return jobService.addJob(jobRequest);
    }

    @GetMapping({"/alumni/jobs" ,"/student/internships"})
    public List<Jobs> findallJobs(){
        return jobService.getJobsData();
    }
    @GetMapping("/job/{id}")
    public Jobs findJobById(@PathVariable Long id){
        return jobService.getJobById(id);
    }
}
