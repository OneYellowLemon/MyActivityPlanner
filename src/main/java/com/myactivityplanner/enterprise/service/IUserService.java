package com.myactivityplanner.enterprise.service;

public interface IUserService {
    /**
     * Create a new user
     * @param firstName The first name of the user
     * @param lastName The last name of the user
     * @return True if the user was created successfully, otherwise false
     */
    boolean createUser(String firstName, String lastName);

    /**
     * Get the full name of a user
     * @param userId The ID of the user to get the name of
     * @return The full name of the user
     */
    String getUserName(int userId);
}
