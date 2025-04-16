package com.myactivityplanner.enterprise.service;

import com.myactivityplanner.enterprise.dto.Activity;
import com.myactivityplanner.enterprise.dto.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Profile("test")
public class ActivityServiceStub implements IActivityService {

    @Override
    public List<User> getUsersSignedUpForActivity(int activityId) {
        User testUser = new User();
        testUser.setFirstName("Test First Name");
        testUser.setLastName("Test Last Name");
        return List.of(testUser);
    }

    @Override
    public List<Activity> getActivitiesForDate(LocalDate date) {
        Activity activity = new Activity();
        activity.setActivityId(1);
        activity.setName("Test Activity");
        activity.setDescription("This is a test activity");
        activity.setLocation("Test Location");
        activity.setTimestamp(LocalDate.now());
        return List.of(activity);
    }

    @Override
    public List<Activity> getSignedUpActivitiesForUser(int userId) {
        Activity activity = new Activity();
        activity.setActivityId(1);
        activity.setName("Test Activity");
        activity.setDescription("This is a test activity");
        activity.setLocation("Test Location");
        activity.setTimestamp(LocalDate.now());
        return List.of(activity);
    }

    @Override
    public List<Activity> getSignedUpActivitiesForUserForDate(int userId, LocalDate date) {
        Activity activity = new Activity();
        activity.setActivityId(1);
        activity.setName("Test Activity");
        activity.setDescription("This is a test activity");
        activity.setLocation("Test Location");
        activity.setTimestamp(LocalDate.now());
        return List.of(activity);
    }

    @Override
    public boolean isUserSignedUpForActivity(int userId, int activityId) {
        return true;
    }

    @Override
    public void signUpForActivity(int activityId, int userId) {
        // empty stub method (void)
    }

    @Override
    public void withdrawFromActivity(int activityId, int userId) {
        // empty stub method (void)
    }

    @Override
    public Activity getActivity(int activityId) {
        Activity activity = new Activity();
        activity.setActivityId(activityId);
        activity.setName("Test Activity");
        activity.setDescription("This is a test activity");
        activity.setLocation("Test Location");
        activity.setTimestamp(LocalDate.now());
        return activity;
    }

    @Override
    public Activity saveActivity(Activity activity) {
        return activity;
    }

    @Override
    public int deleteActivity(int activityId) {
        return activityId;
    }
}
