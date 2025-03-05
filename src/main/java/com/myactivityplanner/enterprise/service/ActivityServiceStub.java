package com.myactivityplanner.enterprise.service;

import com.myactivityplanner.enterprise.dto.Activity;
import com.myactivityplanner.enterprise.dto.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Profile("test")
public class ActivityServiceStub implements IActivityService {

    @Override
    public List<User> getUsersSignedUpForActivity(int activityId) {
        return List.of();
    }

    @Override
    public List<Activity> getActivitiesForDate(Date date) {
        return List.of();
    }

    @Override
    public List<Activity> getSignedUpActivitiesForUser(int userId) {
        return List.of();
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
}
