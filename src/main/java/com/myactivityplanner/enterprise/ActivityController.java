package com.myactivityplanner.enterprise;

import com.myactivityplanner.enterprise.dto.Activity;
import com.myactivityplanner.enterprise.dto.User;
import com.myactivityplanner.enterprise.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    public boolean saveActivity(@RequestBody Activity activity) {
        return activityService.saveActivity(activity);
    }

    /**
     * API endpoint to delete an activity
     * @param id The ID of the activity to delete
     * @return True if the activity was deleted successfully, otherwise false
     */
    @DeleteMapping("api/activity/{id}")
    @ResponseBody
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

    /**
     * API endpoint to get users signed up for activity
     * @param activityId The ID of the activity to get signed-up users for
     * @return A list of users signed up for the activity
     */
    @GetMapping("api/activity/signedupusers/{activityId}")
    @ResponseBody
    public List<User> getUsersSignedUpForActivity(@PathVariable int activityId) {
        return activityService.getUsersSignedUpForActivity(activityId);
    }

    /**
     * API endpoint to get activities a user is signed up for
     * @param userId The ID of the user to get activities for
     * @return A list of activities the user is signed up for
     */
    @GetMapping("api/activity/signedupfor/{userId}")
    @ResponseBody
    public List<Activity> getSignedUpActivitiesForUser(@PathVariable int userId) {
        return activityService.getSignedUpActivitiesForUser(userId);
    }

    /**
     * API endpoint to get activities for date
     * @param date The date to get activities for
     * @return A list of activities for the specified date
     */
    @PostMapping("api/activity/activitiesForDate")
    @ResponseBody
    public List<Activity> getActivitiesForDate(@RequestBody Date date) {
        return activityService.getActivitiesForDate(date);
    }

    /**
     * API endpoint to sign up a user for an activity
     * @param activityId The ID of the activity to sign up for
     * @param userId The ID of the user to sign up
     * @return True if the user was signed up successfully, otherwise false
     */
    @PostMapping("api/activity/signup/{activityId}/{userId}")
    @ResponseBody
    public boolean signUpForActivity(@PathVariable int activityId, @PathVariable int userId) {
        return activityService.signUpForActivity(activityId, userId);
    }

    /**
     * API endpoint to withdraw a user from an activity
     * @param activityId The ID of the activity to withdraw the user from
     * @param userId The ID of the user to withdraw
     * @return True if the user was withdrawn successfully, otherwise false
     */
    @DeleteMapping("api/activity/withdraw/{activityId}/{userId}")
    @ResponseBody
    public boolean withdrawFromActivity(@PathVariable int activityId, @PathVariable int userId) {
        return activityService.withdrawFromActivity(activityId, userId);
    }
}