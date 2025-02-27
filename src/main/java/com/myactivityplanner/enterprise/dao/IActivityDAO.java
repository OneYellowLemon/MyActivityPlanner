package com.myactivityplanner.enterprise.dao;

import com.myactivityplanner.enterprise.dto.Activity;

import java.util.List;

public interface IActivityDAO {
    /**
     * Get activity by ID
     * @param activityId The ID of the activity to get
     * @return The activity with the specified ID
     */
    Activity getActivity(int activityId);

    /**
     * Get a list of all activities
     * @return A list of all activities
     */
    List<Activity> getActivities();

    /**
     * Save a new activity or update exising activity
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
