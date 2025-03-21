package com.myactivityplanner.enterprise.dao;

import com.myactivityplanner.enterprise.dto.Activity;

import java.io.IOException;
import java.util.List;

public interface IActivityDAO {
    /**
     * Get activity by ID
     * @param activityId The ID of the activity to get
     * @return The activity with the specified ID
     * @throws IOException If a database error occurs
     */
    Activity getActivity(int activityId) throws IOException;

    /**
     * Get a list of all activities
     * @return A list of all activities
     * @throws IOException If a database error occurs
     */
    List<Activity> getActivities() throws IOException;

    /**
     * Save a new activity or update exising activity
     * @param activity The activity to save
     * @return The saved activity
     * @throws IOException If a database error occurs
     */
    Activity saveActivity(Activity activity) throws IOException;

    /**
     * Delete an activity
     * @param activityId The ID of the activity to delete
     * @throws IOException If a database error occurs
     */
    void deleteActivity(int activityId) throws IOException;
}
