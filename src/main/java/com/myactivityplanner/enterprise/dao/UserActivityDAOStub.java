package com.myactivityplanner.enterprise.dao;

import com.myactivityplanner.enterprise.dto.Activity;
import com.myactivityplanner.enterprise.dto.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserActivityDAOStub implements IUserActivityDAO {
    @Override
    public boolean isUserSignedUpForActivity(int userId, int activityId) {
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
    public void signUpUser(int userId, int activityId) {
        // empty stub method (void)
    }

    @Override
    public void withdrawUser(int userId, int activityId) {
        // empty stub method (void)
    }
}
