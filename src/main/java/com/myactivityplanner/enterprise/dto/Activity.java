package com.myactivityplanner.enterprise.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int activityId;

    @Column(length = 50)
    private String name;
    private LocalDate timestamp;
    @Column(length = 50)
    private String location;
    @Column(length = 500)
    private String description;
}
