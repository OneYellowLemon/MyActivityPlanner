package com.myactivityplanner.enterprise.service;

import com.myactivityplanner.enterprise.dto.User;

import java.util.List;

public interface IUserService {
    /**
     * Create a new user
     * @param firstName The first name of the user
     * @param lastName The last name of the user
     * @return The created user
     * @throws Exception If an error occurs
     */
    User createUser(String firstName, String lastName) throws Exception;

    /**
     * Get the full name of a user
     * @param userId The ID of the user to get the name of
     * @return The full name of the user
     * @throws Exception If an error occurs
     */
    String getUserName(int userId) throws Exception;

    /**
     * Get the list of all users
     * @return A list of all users
     * @throws Exception If an error occurs
     */
    List<User> getUsers() throws Exception;
}
