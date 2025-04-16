package com.myactivityplanner.enterprise.service;

import com.myactivityplanner.enterprise.dto.Activity;
import com.myactivityplanner.enterprise.dto.User;

import java.time.LocalDate;
import java.util.List;

public interface IActivityService {
    /**
     * Get a list of users signed up for a specified activity
     * @param activityId The ID of the activity to look up
     * @return A list of users signed up for the activity
     * @throws Exception If an error occurs
     */
    List<User> getUsersSignedUpForActivity(int activityId) throws Exception;

    /**
     * Get a list of activities for a specified date
     * @param date The date to get activities for
     * @return A list of activities for the specified date
     * @throws Exception If an error occurs
     */
    List<Activity> getActivitiesForDate(LocalDate date) throws Exception;

    /**
     * Get a list of activities a user is signed up for
     * @param userId The ID of the user to get activities for
     * @return A list of activities the user is signed up for
     * @throws Exception If an error occurs
     */
    List<Activity> getSignedUpActivitiesForUser(int userId) throws Exception;

    /**
     * Get a list of activities a user is signed up for on a specific date
     * @param userId The ID of the user to get activities for
     * @param date The date to get activities for
     * @return A list of activities the user is signed up for on the specified date
     * @throws Exception If an error occurs
     */
    List<Activity> getSignedUpActivitiesForUserForDate(int userId, LocalDate date) throws Exception;

    /**
     * Check if a user is signed up for a specified activity
     * @param userId The ID of the user to check
     * @param activityId The ID of the activity to check
     * @return True if the user is signed up for the activity, otherwise false
     * @throws Exception If an error occurs
     */
    boolean isUserSignedUpForActivity(int userId, int activityId) throws Exception;

    /**
     * Sign up a user for an activity
     * @param activityId The ID of the activity to sign up for
     * @param userId The ID of the user to sign up
     * @throws Exception If an error occurs
     */
    void signUpForActivity(int activityId, int userId) throws Exception;

    /**
     * Withdraw a user from an activity
     * @param activityId The ID of the activity to withdraw from
     * @param userId The ID of the user to withdraw
     * @throws Exception If an error occurs
     */
    void withdrawFromActivity(int activityId, int userId) throws Exception;

    /**
     * Get an activity by ID
     * @param activityId The ID of the activity to get
     * @return The activity with the specified ID
     * @throws Exception If an error occurs
     */
    Activity getActivity(int activityId) throws Exception;

    /**
     * Save an activity
     * @param activity The activity to save
     * @return The saved activity
     * @throws Exception If an error occurs
     */
    Activity saveActivity(Activity activity) throws Exception;

    /**
     * Delete an activity
     * @param activityId The ID of the activity to delete
     * @return The ID of the deleted activity, or -1 if not found
     * @throws Exception If an error occurs
     */
    int deleteActivity(int activityId) throws Exception;
}
