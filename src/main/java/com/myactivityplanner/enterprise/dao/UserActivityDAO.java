package com.myactivityplanner.enterprise.dao;

import com.myactivityplanner.enterprise.dto.UserActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository("userActivityDAO")
public class UserActivityDAO implements IUserActivityDAO {

    @Autowired
    IUserActivityRepository userActivityRepository;

    @Override
    public List<UserActivity> getAllUserActivities() throws IOException {
        return (List<UserActivity>) userActivityRepository.findAll();
    }

    @Override
    public void signUpUser(int userId, int activityId) throws IOException {
        UserActivity userActivity = new UserActivity();
        userActivity.setUser(userId);
        userActivity.setActivity(activityId);
        userActivityRepository.save(userActivity);
    }

    @Override
    public void withdrawUser(int userId, int activityId) throws IOException {
        // Delete all matching records
        Iterable<UserActivity> userActivities = userActivityRepository.findAll();
        for (UserActivity userActivity : userActivities) {
            if (userActivity.getUser() == userId && userActivity.getActivity() == activityId) {
                userActivityRepository.delete(userActivity);
            }
        }
    }
}
