package com.myactivityplanner.enterprise.dto;

import lombok.Data;

@Data
public class User {
    private int userId;
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return null;
    }

    public String getLastName() {
        return null;
    }
}

