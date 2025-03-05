package com.myactivityplanner.enterprise.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("test")
public class UserActivityDAOStub implements IUserActivityDAO {
    @Override
    public boolean isUserSignedUpForActivity(int userId, int activityId) {
        return true;
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
