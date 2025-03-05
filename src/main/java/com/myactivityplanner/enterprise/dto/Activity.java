package com.myactivityplanner.enterprise.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Activity {
    public int activityId;
    public String name;
    public Date timestamp;
    public String location;
    public String description;
}
