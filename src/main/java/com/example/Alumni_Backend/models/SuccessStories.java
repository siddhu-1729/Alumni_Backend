package com.example.Alumni_Backend.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "articles")
public class SuccessStories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tiltle;
    @Column(length = 10000)
    private String content;
    private LocalDateTime createdAt= LocalDateTime.now();
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getTiltle() {
        return tiltle;
    }

    public void setTiltle(String tiltle) {
        this.tiltle = tiltle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
