package com.myactivityplanner.enterprise.dao;

import com.myactivityplanner.enterprise.dto.User;

public interface IUserDAO {
    /**
     * Create a new user
     * @param firstName The first name of the user
     * @param lastName The last name of the user
     * @return True if the user was created successfully, otherwise false
     */
    boolean createUser(String firstName, String lastName);

    /**
     * Get a user by ID
     * @param userId The ID of the user to get
     * @return The user with the specified ID
     */
    User getUser(int userId);
}
