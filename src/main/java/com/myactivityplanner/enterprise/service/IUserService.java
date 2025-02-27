package com.myactivityplanner.enterprise.service;

public interface IUserService {
    /**
     * Get the full name of a user
     * @param userId The ID of the user to get the name of
     * @return The full name of the user
     */
    String getUserName(int userId);
}
