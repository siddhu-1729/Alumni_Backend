package com.example.Alumni_Backend.DTO;

public class SignupRequest {
    private String username;
    private String password;
    private String email;
    private String collegeID;
    private long mobilenumber;
    private String interests;
    private String yearofpassing;
    private String workingcompany;
    private String jobrole;

    private String fullname;
    private String branch;

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(String collegeID) {
        this.collegeID = collegeID;
    }

    public long getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(long mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getYearofpassing() {
        return yearofpassing;
    }

    public void setYearofpassing(String yearofpassing) {
        this.yearofpassing = yearofpassing;
    }

    public String getWorkingcompany() {
        return workingcompany;
    }

    public void setWorkingcompany(String workingcompany) {
        this.workingcompany = workingcompany;
    }

    public String getJobrole() {
        return jobrole;
    }

    public void setJobrole(String jobrole) {
        this.jobrole = jobrole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
