package com.myactivityplanner.enterprise.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Activity {
    private int activityId;
    private String name;
    private Date timestamp;
    private String location;
    private String description;
}
