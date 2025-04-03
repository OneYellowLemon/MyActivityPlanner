package com.myactivityplanner.enterprise.dao;

import com.myactivityplanner.enterprise.dto.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository("activityDAO")
public class ActivityDAO implements IActivityDAO {

    @Autowired
    IActivityRepository activityRepository;

    @Override
    public Activity getActivity(int activityId) throws IOException {
        return activityRepository.findById(activityId).orElse(null);
    }

    @Override
    public List<Activity> getActivities() throws IOException {
        return (List<Activity>) activityRepository.findAll();
    }

    @Override
    public Activity saveActivity(Activity activity) throws IOException {
        return activityRepository.save(activity);
    }

    @Override
    public void deleteActivity(int activityId) throws IOException {
        activityRepository.deleteById(activityId);
    }
}
