package com.myactivityplanner.enterprise.service;

import com.myactivityplanner.enterprise.dto.Activity;
import com.myactivityplanner.enterprise.dto.User;

import java.util.Date;
import java.util.List;

public interface IActivityService {
    /**
     * Get a list of users signed up for a specified activity
     * @param activityId The ID of the activity to look up
     * @return A list of users signed up for the activity
     */
    List<User> getUsersSignedUpForActivity(int activityId);

    /**
     * Get a list of activities for a specified date
     * @param date The date to get activities for
     * @return A list of activities for the specified date
     */
    List<Activity> getActivitiesDate(Date date);

    /**
     * Get a list of activities a user is signed up for
     * @param userId The ID of the user to get activities for
     * @return A list of activities the user is signed up for
     */
    List<Activity> getSignedUpActivitiesForUser(int userId);

    /**
     * Check if a user is signed up for a specified activity
     * @param userId The ID of the user to check
     * @param activityId The ID of the activity to check
     * @return True if the user is signed up for the activity, otherwise false
     */
    boolean isUserSignedUp(int userId, int activityId);

    /**
     * Sign up a user for an activity
     * @param activityId The ID of the activity to sign up for
     * @param userId The ID of the user to sign up
     * @return True if the user was signed up successfully, otherwise false
     */
    boolean signUpForActivity(int activityId, int userId);

    /**
     * Withdraw a user from an activity
     * @param activityId The ID of the activity to withdraw from
     * @param userId The ID of the user to withdraw
     * @return True if the user was withdrawn successfully, otherwise false
     */
    boolean withdrawFromActivity(int activityId, int userId);

    /**
     * Get an activity by ID
     * @param activityId The ID of the activity to get
     * @return The activity with the specified ID
     */
    Activity getActivity(int activityId);

    /**
     * Save an activity
     * @param activity The activity to save
     * @return True if the activity was saved successfully, otherwise false
     */
    boolean saveActivity(Activity activity);

    /**
     * Delete an activity
     * @param activityId The ID of the activity to delete
     * @return True if the activity was deleted successfully, otherwise false
     */
    boolean deleteActivity(int activityId);
}
