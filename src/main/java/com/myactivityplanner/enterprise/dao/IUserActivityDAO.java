package com.myactivityplanner.enterprise.dao;

import com.myactivityplanner.enterprise.dto.Activity;
import com.myactivityplanner.enterprise.dto.User;

import java.io.IOException;
import java.util.List;

public interface IUserActivityDAO {
    /**
     * Check if a user is signed up for a specified activity
     * @param userId The ID of the user to check
     * @param activityId The ID of the activity to check
     * @return True if the user is signed up for the activity, otherwise false
     * @throws IOException If a database error occurs
     */
    boolean isUserSignedUpForActivity(int userId, int activityId) throws IOException;

    /**
     * Get a list of users signed up for a specified activity
     * @param activityId The ID of the activity to get users for
     * @return A list of users signed up for the activity
     * @throws IOException If a database error occurs
     */
    List<User> getUsersSignedUpForActivity(int activityId) throws IOException;

    /**
     * Get a list of activities a specified user is signed up for
     * @param userId The ID of the user to get activities for
     * @return A list of activities the user is signed up for
     * @throws IOException If a database error occurs
     */
    List<Activity> getActivitiesUserIsSignedUpFor(int userId) throws IOException;

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
