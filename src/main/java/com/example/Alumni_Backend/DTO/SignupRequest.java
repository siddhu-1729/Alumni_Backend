
package com.example.Alumni_Backend.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) // Handles extra fields like "section"
public class SignupRequest {
    private String username;
    private String password;
    private String email;

    // This allows Jackson to accept "collegeID", "collegeid", or "collegeId"
    @JsonProperty("collegeID")
    @JsonAlias({"collegeid", "collegeId"})
    private String collegeID;


    // This allows Jackson to accept "linkedin" or "linkedIn"
    @JsonProperty("linkedin")
    @JsonAlias("linkedIn")
    private String linkedIn;





    private String mobilenumber;
    private String interests;
    private String yearofpassing;
    private String workingcompany;
    private String jobrole;
    private String github;


    private String fullname;
    private String branch;
    private String section;

    // --- Getters and Setters ---

    public String getSection() { return section; }
    public void setSection(String section) { this.section = section; }

    public String getMobilenumber() { return mobilenumber; }
    public void setMobilenumber(String mobilenumber) { this.mobilenumber = mobilenumber; }

    public String getLinkedIn() { return linkedIn; }
    public void setLinkedIn(String linkedIn) { this.linkedIn = linkedIn; }

    public String getGithub() { return github; }
    public void setGithub(String github) { this.github = github; }

    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }

    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCollegeID() { return collegeID; }
    public void setCollegeID(String collegeID) { this.collegeID = collegeID; }

    public String getInterests() { return interests; }
    public void setInterests(String interests) { this.interests = interests; }

    public String getYearofpassing() { return yearofpassing; }
    public void setYearofpassing(String yearofpassing) { this.yearofpassing = yearofpassing; }

    public String getWorkingcompany() { return workingcompany; }
    public void setWorkingcompany(String workingcompany) { this.workingcompany = workingcompany; }

    public String getJobrole() { return jobrole; }
    public void setJobrole(String jobrole) { this.jobrole = jobrole; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}