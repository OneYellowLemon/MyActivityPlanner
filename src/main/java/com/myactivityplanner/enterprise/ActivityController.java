package com.myactivityplanner.enterprise;

import com.myactivityplanner.enterprise.dto.Activity;
import com.myactivityplanner.enterprise.dto.User;
import com.myactivityplanner.enterprise.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Controller
public class ActivityController {

    @Autowired
    IActivityService activityService;

    /**
     * Handle the root (/) endpoint and return a start page
     * @return index.html UI page
     */
    @RequestMapping
    public String index() {
        return "index";
    }

    /**
     * API endpoint to get activity by ID
     * @param id The ID of the activity to get
     * @return The activity with the given ID
     */
    @GetMapping("api/activity/{id}")
    @ResponseBody
    public Activity getActivity(@PathVariable int id) {
        return activityService.getActivity(id);
    }

    /**
     * API endpoint to save an activity
     * @param activity The activity to save
     * @return True if the activity was saved successfully, otherwise false
     */
    @PutMapping("api/activity")
    public boolean saveActivity(@RequestBody Activity activity) {
        return activityService.saveActivity(activity);
    }

    /**
     * API endpoint to delete an activity
     * @param id The ID of the activity to delete
     * @return True if the activity was deleted successfully, otherwise false
     */
    @DeleteMapping("api/activity/{id}")
    public boolean deleteActivity(@PathVariable int id) {
        return activityService.deleteActivity(id);
    }

    /**
     * API endpoint to check if user is signed up for activity
     * @param activityId The ID of the activity to check
     * @param userId The ID of the user to check
     * @return True if the user is signed up for the activity, otherwise false
     */
    @GetMapping("api/activity/signedup/{activityId}/{userId}")
    @ResponseBody
    public boolean isUserSignedUpForActivity(@PathVariable int userId, @PathVariable int activityId) {
        return activityService.isUserSignedUpForActivity(userId, activityId);
    }
    
    @GetMapping("api/activity/getSignedUpActivities/{activityId}")
    public List<User> getSignedUpActivitiesForUser(@PathVariable int activityId) {
        return activityService.getSignedUpActivitiesForUser(activityId);
    }

    @GetMapping("api/activity/activitiesForDate/{timestamp}")
    public List<Activity> getActivitiesForDate(@PathVariable Date date) {
        return activityService.getActivitiesForDate(date);
    }

    @GetMapping("api/activity/activitiesUserSignedUpFor/{userId}")
    public List<Activity> getActivitiesUserIsSignedUpFor(@PathVariable int userId) {
        return activityService.getActivitiesUserIsSignedUpFor(userId);
    }

    @GetMapping("api/activity/signUpForActivity/{activityId}/{userId}")
    @ResponseBody
    public boolean signUpForActivity(@PathVariable int activityId, @PathVariable int userId) {
        return activityService.signUpForActivity(activityId, userId);
    }

    @DeleteMapping("api/activity/withdrawFromActivity/{activityId}/{userId}")
    public boolean withdrawFromActivity(@PathVariable int activityId, @PathVariable int userId) {
        return activityService.withdrawFromActivity(activityId, userId);
    }
}