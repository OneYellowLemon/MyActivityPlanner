package com.myactivityplanner.enterprise.dao;

import com.myactivityplanner.enterprise.dto.Activity;
import com.myactivityplanner.enterprise.dto.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("test")
public class UserActivityDAOStub implements IUserActivityDAO {
    @Override
    public boolean isUserSignedUp(int userId, int activityId) {
        return true;
    }

    @Override
    public List<User> getUsersSignedUpForActivity(int activityId) {
        return new ArrayList<>();
    }

    @Override
    public List<Activity> getActivitiesUserIsSignedUpFor(int userId) {
        return new ArrayList<>();
    }

    @Override
    public boolean signUpUser(int userId, int activityId) {
        return true;
    }

    @Override
    public boolean withdrawUser(int userId, int activityId) {
        return true;
    }
}
