package com.myactivityplanner.enterprise.service;

import com.myactivityplanner.enterprise.dto.Activity;
import com.myactivityplanner.enterprise.dto.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ActivityServiceStub implements IActivityService {

    private final List<Activity> activities = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    private Activity createTestActivity(int id, String name, String location) {
        Activity activity = new Activity();
        activity.setActivityId(id);
        activity.setName(name);
        activity.setDescription("This is a test activity");
        activity.setLocation(location);
        activity.setTimestamp(new Date());
        return activity;
    }

    private User createTestUser(int userId) {
        User user = new User();
        user.setUserId(userId);
        user.setFirstName("Test First Name");
        user.setLastName("Test Last Name");
        return user;
    }

    @Override
    public List<User> getUsersSignedUpForActivity(int activityId) {
        User testUser = createTestUser(1);
        return List.of(testUser);
    }

    @Override
    public List<Activity> getActivitiesForDate(Date date) {
        Activity activity = createTestActivity(1, "Test Activity", "Test Location");
        activity.setTimestamp(date);
        return List.of(activity);
    }

    @Override
    public List<Activity> getSignedUpActivitiesForUser(int userId) {
        Activity activity = createTestActivity(1, "Test Activity", "Test Location");
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
        return activities.stream()
                .filter(activity -> activity.getActivityId() == activityId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean saveActivity(Activity activity) {
        return activities.add(activity);
    }

    @Override
    public boolean deleteActivity(int activityId) {
        return activities.removeIf(activity -> activity.getActivityId() == activityId);
    }
}
