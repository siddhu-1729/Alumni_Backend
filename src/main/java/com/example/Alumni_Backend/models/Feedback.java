package com.example.Alumni_Backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "feedbacks")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long eventId;

    private int rating;

    private int instructor_rating;

    private int course_material;

    private int recommendation;

    private String content;

    private String comments;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getInstructor_rating() {
        return instructor_rating;
    }

    public void setInstructor_rating(int instructor_rating) {
        this.instructor_rating = instructor_rating;
    }

    public int getCourse_material() {
        return course_material;
    }

    public void setCourse_material(int course_material) {
        this.course_material = course_material;
    }

    public int getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(int recommendation) {
        this.recommendation = recommendation;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
