package com.myactivityplanner.enterprise.service;

import com.myactivityplanner.enterprise.dao.IActivityDAO;
import com.myactivityplanner.enterprise.dao.IUserActivityDAO;
import com.myactivityplanner.enterprise.dao.IUserDAO;
import com.myactivityplanner.enterprise.dto.Activity;
import com.myactivityplanner.enterprise.dto.User;
import com.myactivityplanner.enterprise.dto.UserActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityService implements IActivityService {
    @Autowired
    IActivityDAO activityDAO;

    @Autowired
    IUserDAO userDAO;

    @Autowired
    IUserActivityDAO userActivityDAO;

    @Override
    public List<User> getUsersSignedUpForActivity(int activityId) throws Exception {
        List<UserActivity> userActivities = userActivityDAO.getAllUserActivities();
        List<User> users = new ArrayList<>();

        for (UserActivity userActivity : userActivities) {
            if (userActivity.getActivity() == activityId) {
                User user = userDAO.getUser(userActivity.getUser());
                users.add(user);
            }
        }

        return users;
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
        List<UserActivity> userActivities = userActivityDAO.getAllUserActivities();

        List<Activity> activities = new ArrayList<>();
        for (UserActivity userActivity : userActivities) {
            if (userActivity.getUser() == userId) {
                Activity activity = activityDAO.getActivity(userActivity.getActivity());
                activities.add(activity);
            }
        }

        return activities;
    }

    @Override
    public List<Activity> getSignedUpActivitiesForUserForDate(int userId, LocalDate date) throws Exception {
        List<UserActivity> userActivities = userActivityDAO.getAllUserActivities();

        List<Activity> activities = new ArrayList<>();
        for (UserActivity userActivity : userActivities) {
            if (userActivity.getUser() == userId) {
                Activity activity = activityDAO.getActivity(userActivity.getActivity());
                if (activity.getTimestamp().equals(date)) {
                    activities.add(activity);
                }
            }
        }

        return activities;
    }

    @Override
    public boolean isUserSignedUpForActivity(int userId, int activityId) throws Exception {
        List<UserActivity> userActivities = userActivityDAO.getAllUserActivities();

        for (UserActivity userActivity : userActivities) {
            if (userActivity.getUser() == userId && userActivity.getActivity() == activityId) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void signUpForActivity(int activityId, int userId) throws Exception {
        // Check if the user is already signed up for the activity
        if (this.isUserSignedUpForActivity(userId, activityId)) {
            throw new Exception("Already signed up for this activity!");
        }

        userActivityDAO.signUpUser(userId, activityId);
    }

    @Override
    public void withdrawFromActivity(int activityId, int userId) throws Exception {
        // Check if the user is signed up for the activity
        if (!this.isUserSignedUpForActivity(userId, activityId)) {
            throw new Exception("Not signed up for this activity!");
        }

        userActivityDAO.withdrawUser(userId, activityId);
    }

    @Override
    public Activity getActivity(int activityId) throws Exception {
        return activityDAO.getActivity(activityId);
    }

    @Override
    public Activity saveActivity(Activity activity) throws Exception {
        if (activity.getTimestamp().isBefore(LocalDate.now())) {
            throw new Exception("Activity date cannot be in the past!");
        }

        return activityDAO.saveActivity(activity);
    }

    @Override
    public int deleteActivity(int activityId) throws Exception {
        // Check if the activity exists
        Activity activity = activityDAO.getActivity(activityId);
        if (activity == null) {
            return -1;
        }

        // Delete any user activities associated with this activity
        List<UserActivity> userActivities = userActivityDAO.getAllUserActivities();
        for (UserActivity userActivity : userActivities) {
            if (userActivity.getActivity() == activityId) {
                userActivityDAO.withdrawUser(userActivity.getUser(), activityId);
            }
        }

        activityDAO.deleteActivity(activityId);
        return activityId;
    }
}
