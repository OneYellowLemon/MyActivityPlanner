package com.myactivityplanner.enterprise.service;

import com.myactivityplanner.enterprise.dao.IActivityDAO;
import com.myactivityplanner.enterprise.dao.IUserActivityDAO;
import com.myactivityplanner.enterprise.dto.Activity;
import com.myactivityplanner.enterprise.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ActivityService implements IActivityService {
    @Autowired
    private IActivityDAO activityDAO;

    @Autowired
    IUserActivityDAO userActivityDAO;

    @Override
    public List<User> getUsersSignedUpForActivity(int activityId) throws Exception {
        return userActivityDAO.getUsersSignedUpForActivity(activityId);
    }

    @Override
    public List<Activity> getActivitiesForDate(LocalDate date) throws Exception {
        // Get activities
        List<Activity> activities = activityDAO.getActivities();

        // Filter activities by date
        activities.removeIf(activity -> !activity.getTimestamp().equals(date));

        return activities;
    }

    @Override
    public List<Activity> getSignedUpActivitiesForUser(int userId) throws Exception {
        return userActivityDAO.getActivitiesUserIsSignedUpFor(userId);
    }

    @Override
    public boolean isUserSignedUpForActivity(int userId, int activityId) throws Exception {
        return userActivityDAO.isUserSignedUpForActivity(userId, activityId);
    }

    @Override
    public void signUpForActivity(int activityId, int userId) throws Exception {
        userActivityDAO.signUpUser(userId, activityId);
    }

    @Override
    public void withdrawFromActivity(int activityId, int userId) throws Exception {
        userActivityDAO.withdrawUser(userId, activityId);
    }

    @Override
    public Activity getActivity(int activityId) throws Exception {
        return activityDAO.getActivity(activityId);
    }

    @Override
    public Activity saveActivity(Activity activity) throws Exception {
        return activityDAO.saveActivity(activity);
    }

    @Override
    public int deleteActivity(int activityId) throws Exception {
        activityDAO.deleteActivity(activityId);
        return activityId;
    }
}
