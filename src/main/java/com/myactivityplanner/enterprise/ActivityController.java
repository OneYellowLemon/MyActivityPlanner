package com.myactivityplanner.enterprise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.time.LocalDate;


@Controller
public class ActivityController {

    /**
     * Handle the root (/) endpoint and return a start page
     * @return index.html
     */
    @RequestMapping
    public String index() {
        return "index";
    }
/**
 *     @GetMapping
    public LocalDate getActivitiesByDate() {
        /**
         * Retrieves a list of activities on a specific date
         * Or a length of dates?
         * Will request for date and
         * @param date of the activity/ies
         * @return a list of activities occurring on the given date
         *
       * return int LocalDate;
    }
    
    @GetMapping
    public int getUsersByActivity() {
    /**
     * Retrieves a list of users that have signed up for a given activity
     * @param activityID
     * @return a list of users(userID) for the specified activity (array?)
     *
    return int userID;
    }
    
    @GetMapping
    public boolean signUpForActivity() {
        /**
         * @param activityID
         * @param userID
         * @return boolean is True for user being signed up for activity
         *
        *return true;
    }

    @GetMapping
    public boolean isUserSignedUpForActivity() {
        /**
         * @param activityID
         * @param userID
         * @return boolean confirming a user is registered for an activity
         *
        return true;
    }

    @DeleteMapping
    public boolean withdrawFromActivity() {
        /**
         * Allows user to withdraw from an activity
         * @param activityID
         * @param userID
         * @return removal of user from activity list of specified activity
         *
        return false;
    }
    */
}