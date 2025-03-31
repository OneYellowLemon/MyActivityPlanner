package com.myactivityplanner.enterprise.dto;

import lombok.Data;

/**
 * A simple DTO class representing a User.
 * It contains basic information such as user ID, first name, and last name.
 */
@Data
public class User {

    /**
     * The unique identifier for the user.
     */
    private int userId;

    /**
     * The first name of the user.
     */
    private String firstName;

    /**
     * The last name of the user.
     */
    private String lastName;
}
