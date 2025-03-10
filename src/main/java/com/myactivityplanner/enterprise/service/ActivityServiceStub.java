package com.myactivityplanner.enterprise.service;

import com.myactivityplanner.enterprise.dto.Activity;
import com.myactivityplanner.enterprise.dto.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ActivityServiceStub implements IActivityService {

    @Override
    public List<User> getUsersSignedUpForActivity(int activityId) {
        User testUser = new User();
        testUser.setFirstName("Test First Name");
        testUser.setLastName("Test Last Name");
        return List.of(testUser);
    }

    @Override
    public List<Activity> getActivitiesForDate(Date date) {
        Activity activity = new Activity();
        activity.setActivityId(1);
        activity.setName("Test Activity");
        activity.setDescription("This is a test activity");
        activity.setLocation("Test Location");
        activity.setTimestamp(date);
        return List.of(activity);
    }

    @Override
    public List<Activity> getSignedUpActivitiesForUser(int userId) {
        Activity activity = new Activity();
        activity.setActivityId(1);
        activity.setName("Test Activity");
        activity.setDescription("This is a test activity");
        activity.setLocation("Test Location");
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
        activity.setActivityId(activityId);
        activity.setName("Test Activity");
        activity.setDescription("This is a test activity");
        activity.setLocation("Test Location");
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
