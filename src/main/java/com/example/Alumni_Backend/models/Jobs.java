package com.example.Alumni_Backend.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "jobs")
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobtitile;
    private String company;
    private String location;
    private String jobtype;
    private String salary_range;
    private String jobdescription;
    private String Responsibilities;
    private String qualifications;
    private String benefits;
    private String requiredskills;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobtitile() {
        return jobtitile;
    }

    public void setJobtitile(String jobtitile) {
        this.jobtitile = jobtitile;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobtype() {
        return jobtype;
    }

    public void setJobtype(String jobtype) {
        this.jobtype = jobtype;
    }

    public String getSalary_range() {
        return salary_range;
    }

    public void setSalary_range(String salary_range) {
        this.salary_range = salary_range;
    }

    public String getJobdescription() {
        return jobdescription;
    }

    public void setJobdescription(String jobdescription) {
        this.jobdescription = jobdescription;
    }

    public String getResponsibilities() {
        return Responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        Responsibilities = responsibilities;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getRequiredskills() {
        return requiredskills;
    }

    public void setRequiredskills(String requiredskills) {
        this.requiredskills = requiredskills;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
