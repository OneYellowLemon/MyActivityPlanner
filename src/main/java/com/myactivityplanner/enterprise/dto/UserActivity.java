package com.myactivityplanner.enterprise.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userActivityId;

    private int user;
    private int activity;
}
