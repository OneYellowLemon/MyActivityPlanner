package com.myactivityplanner.enterprise.dao;

public interface IUserDAO {
    /**
     * Create a new user
     * @param firstName The first name of the user
     * @param lastName The last name of the user
     * @return True if the user was created successfully, otherwise false
     */
    boolean createUser(String firstName, String lastName);

}
