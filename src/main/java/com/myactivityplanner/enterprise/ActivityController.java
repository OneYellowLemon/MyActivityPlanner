package com.myactivityplanner.enterprise;

import com.myactivityplanner.enterprise.dto.Activity;
import com.myactivityplanner.enterprise.dto.User;
import com.myactivityplanner.enterprise.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Date;

@Controller
public class ActivityController {

    /* The one thing here is that you are returning true false for these for a success or failure and that is most likely going to cause you issues later on.

     I would recommend that you do some sort of response code instead as that will help you and the frontend.

     There are ways to do custom responses but really if you can use the standard response codes overall ie 200s, 300s, 400s etc that will be good. Especially when it comes to things like auth and such just returning ture/false might not be sufficient you are going to want 400s

     I put in an example please see line 56-69 as they should be not too bad to implement

     There is also another option that I found but it is a little more involved at first and that is create a a global exception handler - I would not really do this I would do that one that I gave already but I created an example file for this and then you will need to change method signatures to allow for the return to be of not boolean (that is why I woudl not do this but it aligns more with the framework)
    */
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
    public ResponseEntity<Activity> saveActivity(@RequestBody Activity activity) {
        try {

            boolean saved = activityService.saveActivity(activity);

            if (saved) {
                return new ResponseEntity<>(activity, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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