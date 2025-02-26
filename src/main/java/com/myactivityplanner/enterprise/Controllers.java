package com.myactivityplanner.enterprise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface ActivityController {
/**
 * Not sure what to put here. Or if anything should be put in here at all
 */
    @GetMapping
    public interface getActivitiesByDate {
        /**
         * Retrieves a list of activities on a specific date
         * Or a length of dates?
         * Will request for date and
         * @param date of the activity/ies
         * @return a list of activities occurring on the given date
         */
    }
    
    @GetMapping
    public interface getUsersByActivity {
    /**
     * Retrieves a list of users that have signed up for a given activity
     * @param activityID
     * @return a list of users(userID) for the specified activity (array?)
     */
    }
    
    @GetMapping
    public interface signUpForActivity {
        /**
         * @param activityID
         * @param userID
         * @return boolean is True for user being signed up for activity
         */
    }

    @GetMapping
    public interface isUserSignedUpForActivity {
        /**
         * @param activityID
         * @param userID
         * @return boolean confirming a user is registered for an activity
         */
    }

    @DeleteMapping
    public interface withdrawFromActivity {
        /**
         * Allows user to withdraw from an activity
         * @param activityID
         * @param userID
         * @return removal of user from activity list of specified activity
         */
    }
}