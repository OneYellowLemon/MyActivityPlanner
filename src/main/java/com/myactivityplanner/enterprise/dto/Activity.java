package com.myactivityplanner.enterprise.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Activity {
    private int activityId;
    private String name;
    private LocalDate timestamp;
    private String location;
    private String description;
}
