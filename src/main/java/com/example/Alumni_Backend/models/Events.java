package com.example.Alumni_Backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @Getter
    private String EventName;
    @Setter
    @Getter
    private String EventDescription;
    @Setter
    @Getter
    private byte[] image;
    @Setter
    @Getter
    private LocalDateTime time;

}
