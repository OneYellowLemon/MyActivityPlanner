package com.myactivityplanner.enterprise.dao;

import com.myactivityplanner.enterprise.dto.UserActivity;

import java.io.IOException;
import java.util.List;

public interface IUserActivityDAO {
    /**
     * Get all user activity objects
     * @return A list of all user activity objects
     * @throws IOException If a database error occurs
     */
    List<UserActivity> getAllUserActivities() throws IOException;

    /**
     * Sign up a user for an activity
     * @param userId The ID of the user to sign up
     * @param activityId The ID of the activity to sign up for
     * @throws IOException If a database error occurs
     */
    void signUpUser(int userId, int activityId) throws IOException;

    /**
     * Withdraw a user from an activity
     * @param userId The ID of the user to withdraw
     * @param activityId The ID of the activity to withdraw from
     * @throws IOException If a database error occurs
     */
    void withdrawUser(int userId, int activityId) throws IOException;
}
