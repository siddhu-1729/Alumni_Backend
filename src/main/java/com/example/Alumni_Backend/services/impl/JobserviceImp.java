package com.example.Alumni_Backend.services.impl;

import com.example.Alumni_Backend.DTO.JobRequest;
import com.example.Alumni_Backend.models.Jobs;
import com.example.Alumni_Backend.repository.JOBsRepo;
import com.example.Alumni_Backend.services.JOBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobserviceImp implements JOBService {
    @Autowired
    private JOBsRepo joBsRepo;


    public Jobs addJob(JobRequest jobRequest){
        Jobs job=new Jobs();
         job.setJobtitile(jobRequest.getJobtitile());
         job.setJobdescription(jobRequest.getJobdescription());
         job.setCompany(jobRequest.getCompany());
         job.setJobtype(jobRequest.getJobtype());
         job.setQualifications(jobRequest.getQualifications());
         job.setRequiredskills(jobRequest.getRequiredskills());
         job.setResponsibilities(jobRequest.getResponsibilities());
         job.setSalary_range(jobRequest.getSalary_range());
         job.setLocation(jobRequest.getLocation());
         return joBsRepo.save(job);
    }

    public List<Jobs> getJobsData(){
        return joBsRepo.findAll();
    }

    public Jobs getJobById(Long id){
        return joBsRepo.findById(id).orElseThrow(()->new UsernameNotFoundException("Job Details not Found"));
    }
}
