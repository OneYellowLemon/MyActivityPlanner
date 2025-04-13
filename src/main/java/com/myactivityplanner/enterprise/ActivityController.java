package com.myactivityplanner.enterprise;

import com.myactivityplanner.enterprise.dto.Activity;
import com.myactivityplanner.enterprise.dto.User;
import com.myactivityplanner.enterprise.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ActivityController {

    @Autowired
    IActivityService activityService;

    /**
     * API endpoint to get activity by ID
     * @param id The ID of the activity to get
     * @return The activity with the given ID
     */
    @GetMapping("api/activity/{id}")
    @ResponseBody
    public ResponseEntity<Activity> getActivity(@PathVariable int id) {
        try {
            Activity activity = activityService.getActivity(id);
            return activity == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(activity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * API endpoint to save an activity
     * @param activity The activity to save
     * @return The saved activity
     */
    @PutMapping("api/activity")
    @ResponseBody
    public ResponseEntity<Activity> saveActivity(@RequestBody Activity activity) {
        try {
            return ResponseEntity.ok(activityService.saveActivity(activity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * API endpoint to delete an activity
     * @param id The ID of the activity to delete
     * @return The ID of the deleted activity
     */
    @DeleteMapping("api/activity/{id}")
    @ResponseBody
    public ResponseEntity<Integer> deleteActivity(@PathVariable int id) {
        try {
            int deletedId = activityService.deleteActivity(id);
            return deletedId == -1 ? ResponseEntity.notFound().build() : ResponseEntity.ok(deletedId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * API endpoint to check if user is signed up for activity
     * @param activityId The ID of the activity to check
     * @param userId The ID of the user to check
     * @return True if the user is signed up for the activity, otherwise false
     */
    @GetMapping("api/activity/signedup/{activityId}/{userId}")
    @ResponseBody
    public ResponseEntity<Boolean> isUserSignedUpForActivity(@PathVariable int userId, @PathVariable int activityId) {
        try {
            return ResponseEntity.ok(activityService.isUserSignedUpForActivity(userId, activityId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * API endpoint to get users signed up for activity
     * @param activityId The ID of the activity to get signed-up users for
     * @return A list of users signed up for the activity
     */
    @GetMapping("api/activity/signedupusers/{activityId}")
    @ResponseBody
    public ResponseEntity<List<User>> getUsersSignedUpForActivity(@PathVariable int activityId) {
        try {
            return ResponseEntity.ok(activityService.getUsersSignedUpForActivity(activityId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * API endpoint to get activities a user is signed up for
     * @param userId The ID of the user to get activities for
     * @return A list of activities the user is signed up for
     */
    @GetMapping("api/activity/signedupfor/{userId}")
    @ResponseBody
    public ResponseEntity<List<Activity>> getSignedUpActivitiesForUser(@PathVariable int userId) {
        try {
            return ResponseEntity.ok(activityService.getSignedUpActivitiesForUser(userId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * API endpoint to get activities for date
     * @param date The date to get activities for
     * @return A list of activities for the specified date
     */
    @PostMapping("api/activity/activitiesForDate")
    @ResponseBody
    public ResponseEntity<List<Activity>> getActivitiesForDate(@RequestBody LocalDate date) {
        try {
            return ResponseEntity.ok(activityService.getActivitiesForDate(date));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * API endpoint to sign up a user for an activity
     * @param activityId The ID of the activity to sign up for
     * @param userId The ID of the user to sign up
     */
    @PostMapping("api/activity/signup/{activityId}/{userId}")
    @ResponseBody
    public ResponseEntity<Void> signUpForActivity(@PathVariable int activityId, @PathVariable int userId) {
        try {
            activityService.signUpForActivity(activityId, userId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * API endpoint to withdraw a user from an activity
     * @param activityId The ID of the activity to withdraw the user from
     * @param userId The ID of the user to withdraw
     */
    @DeleteMapping("api/activity/withdraw/{activityId}/{userId}")
    @ResponseBody
    public ResponseEntity<Void> withdrawFromActivity(@PathVariable int activityId, @PathVariable int userId) {
        try {
            activityService.withdrawFromActivity(activityId, userId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}