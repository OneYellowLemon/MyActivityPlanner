package com.myactivityplanner.enterprise.dao;

import com.myactivityplanner.enterprise.dto.Activity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ActivityDAOStub implements IActivityDAO {
    Map<Integer, Activity> activities = new HashMap<>();

    @Override
    public Activity getActivity(int id) {
        return activities.get(id);
    }

    @Override
    public List<Activity> getActivities() {
        return new ArrayList<>(activities.values());
    }

    @Override
    public Activity saveActivity(Activity activity) {
        activities.put(activity.getActivityId(), activity);
        return activity;
    }

    @Override
    public void deleteActivity(int id) {
        activities.remove(id);
    }
}
