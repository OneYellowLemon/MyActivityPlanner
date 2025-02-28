package com.myactivityplanner.enterprise.dao;

public interface IUserActivityDAO {
    /**
     * Check if a user is signed up for a specified activity
     * @param userId The ID of the user to check
     * @param activityId The ID of the activity to check
     * @return True if the user is signed up for the activity, otherwise false
     */
    boolean isUserSignedUpForActivity(int userId, int activityId);

    /**
     * Sign up a user for an activity
     * @param userId The ID of the user to sign up
     * @param activityId The ID of the activity to sign up for
     * @return True if the user was signed up successfully, otherwise false
     */
    boolean signUpUser(int userId, int activityId);

    /**
     * Withdraw a user from an activity
     * @param userId The ID of the user to withdraw
     * @param activityId The ID of the activity to withdraw from
     * @return True if the user was withdrawn successfully, otherwise false
     */
    boolean withdrawUser(int userId, int activityId);
}
