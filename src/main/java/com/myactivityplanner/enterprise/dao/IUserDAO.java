package com.myactivityplanner.enterprise.dao;

import com.myactivityplanner.enterprise.dto.User;

import java.io.IOException;
import java.util.List;

public interface IUserDAO {
    /**
     * Create a new user
     * @param firstName The first name of the user
     * @param lastName The last name of the user
     * @return The created user
     * @throws IOException If a database error occurs
     */
    User createUser(String firstName, String lastName) throws IOException;

    /**
     * Get a user by ID
     * @param userId The ID of the user to get
     * @return The user with the specified ID
     * @throws IOException If a database error occurs
     */
    User getUser(int userId) throws IOException;

    /**
     * Get all users
     * @return A list of all users
     * @throws IOException If a database error occurs
     */
    List<User> getUsers() throws IOException;
}
