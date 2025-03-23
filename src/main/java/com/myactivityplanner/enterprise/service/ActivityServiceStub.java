package com.myactivityplanner.enterprise.service;

import com.myactivityplanner.enterprise.dto.Activity;
import com.myactivityplanner.enterprise.dto.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.ArrayList; // Import ArrayList

@Service
public class ActivityServiceStub implements IActivityService {
    // Maybe use these constants for testing this might make it easier then repeating hard coded values
    // contstant for the activity
    private static final int DEFAULT_ACTIVITY_ID = 1;
    private static final String DEFAULT_ACTIVITY_NAME = "Test Activity";
    private static final String DEFAULT_ACTIVITY_DESCRIPTION = "This is a test activity";
    private static final String DEFAULT_ACTIVITY_LOCATION = "Test Location";

    // constants for the user
    private static final String DEFAULT_USER_FIRST_NAME = "Test First Name";
    private static final String DEFAULT_USER_LAST_NAME = "Test Last Name";


    @Override
    public List<User> getUsersSignedUpForActivity(int activityId) {
        User testUser = new User();
        testUser.setFirstName(DEFAULT_USER_FIRST_NAME);
        testUser.setLastName(DEFAULT_USER_LAST_NAME);
        return List.of(testUser); // More concise way to create a single-element list
    }

    @Override
    public List<Activity> getActivitiesForDate(Date date) {
        Activity activity = new Activity();
        activity.setActivityId(DEFAULT_ACTIVITY_ID);
        activity.setName(DEFAULT_ACTIVITY_NAME);
        activity.setDescription(DEFAULT_ACTIVITY_DESCRIPTION);
        activity.setLocation(DEFAULT_ACTIVITY_LOCATION);
        activity.setTimestamp(date);
        return List.of(activity);
    }

    @Override
    public List<Activity> getSignedUpActivitiesForUser(int userId) {
        Activity activity = new Activity();
        activity.setActivityId(DEFAULT_ACTIVITY_ID);
        activity.setName(DEFAULT_ACTIVITY_NAME);
        activity.setDescription(DEFAULT_ACTIVITY_DESCRIPTION);
        activity.setLocation(DEFAULT_ACTIVITY_LOCATION);
        activity.setTimestamp(new Date());
        return List.of(activity);
    }

    @Override
    public boolean isUserSignedUpForActivity(int userId, int activityId) {
        return true;
    }

    @Override
    public boolean signUpForActivity(int activityId, int userId) {
        return true;
    }

    @Override
    public boolean withdrawFromActivity(int activityId, int userId) {
        return true;
    }

    @Override
    public Activity getActivity(int activityId) {
        Activity activity = new Activity();
        activity.setActivityId(activityId); // Keep activityId, as it's a parameter
        activity.setName(DEFAULT_ACTIVITY_NAME);
        activity.setDescription(DEFAULT_ACTIVITY_DESCRIPTION);
        activity.setLocation(DEFAULT_ACTIVITY_LOCATION);
        activity.setTimestamp(new Date());
        return activity;
    }

    @Override
    public boolean saveActivity(Activity activity) {
        return true;
    }

    @Override
    public boolean deleteActivity(int activityId) {
        return true;
    }
}
