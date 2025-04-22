package com.myactivityplanner.enterprise.dao;

import com.myactivityplanner.enterprise.dto.UserActivity;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
@Profile("test")
public class UserActivityDAOStub implements IUserActivityDAO {
    @Override
    public List<UserActivity> getAllUserActivities() throws IOException {
        UserActivity userActivity = new UserActivity();
        userActivity.setUser(1);
        userActivity.setActivity(1);
        return List.of(userActivity);
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
