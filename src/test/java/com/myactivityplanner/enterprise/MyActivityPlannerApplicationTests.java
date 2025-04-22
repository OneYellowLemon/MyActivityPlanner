package com.myactivityplanner.enterprise;

import com.myactivityplanner.enterprise.dao.IActivityDAO;
import com.myactivityplanner.enterprise.dao.IUserActivityDAO;
import com.myactivityplanner.enterprise.dao.IUserDAO;
import com.myactivityplanner.enterprise.dto.Activity;
import com.myactivityplanner.enterprise.dto.User;
import com.myactivityplanner.enterprise.dto.UserActivity;
import com.myactivityplanner.enterprise.service.IActivityService;
import com.myactivityplanner.enterprise.service.IUserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyActivityPlannerApplicationTests {

    @Autowired
    private IActivityService activityService;
    @Autowired
    private IUserService userService;

    @MockitoBean
    private IActivityDAO activityDAO;

    @MockitoBean
    private IUserDAO userDAO;

    @MockitoBean
    private IUserActivityDAO userActivityDAO;

    @Test
    void contextLoads() {
    }

    @Test
    void fetchUserById_returnsUser1Name() throws Exception {
        givenUsersAreAvailable();
        whenGetUser1();
        thenReturnUserNameForUser1();
    }

    @Test
    void fetchAllUsers_returnsAtLeastOne() throws Exception {
        givenUsersAreAvailable();
        whenGetAllUsers();
        thenReturnAtLeastOneUser();
    }

    @Test
    void fetchActivityById_returnsActivity1() throws Exception {
        givenActivitiesAreAvailable();
        whenGetActivity1();
        thenReturnActivity1();
    }

    @Test
    void fetchActivitiesForDate_returnsActivities() throws Exception {
        givenActivitiesAreAvailable();
        whenGetActivity1();
        whenGetActivitiesForDate();
        thenReturnActivity1();
    }

    @Test
    void fetchSignedUpUsersForActivity_returnsAtLeastOneUser() throws Exception {
        givenUsersAreAvailable();
        givenActivitiesAreAvailable();
        whenGetUsersSignedUpForActivity();
        thenReturnAtLeastOneSignedUpUser();
    }

    @Test
    void fetchSignedUpActivitiesForUser_returnsAtLeastOneActivity() throws Exception {
        givenUsersAreAvailable();
        givenActivitiesAreAvailable();
        whenGetActivitiesForUser();
        thenReturnAtLeastOneActivityForUser();
    }

    @Test
    void fetchSignedUpActivitiesForUserForDate_returnsActivitiesForDate() throws Exception {
        LocalDate testDate = LocalDate.of(2023, 6, 15);
        LocalDate otherDate = LocalDate.of(2023, 6, 16);

        givenUsersAreAvailable();
        givenActivitiesForSpecificDates(testDate, otherDate);
        whenUserSignedUpForActivitiesOnDifferentDates();
        thenReturnOnlyActivitiesForSpecificDate(testDate);
    }

    @Test
    void isUserSignedUpForActivity_returnsTrueWhenUserIsSignedUp() throws Exception {
        givenUsersAreAvailable();
        givenActivitiesAreAvailable();
        whenUserSignedUpForActivity();
        thenReturnTrueForUserSignedUpForActivity();
    }

    @Test
    void isUserSignedUpForActivity_returnsFalseWhenUserNotSignedUp() throws Exception {
        givenUsersAreAvailable();
        givenActivitiesAreAvailable();
        whenUserNotSignedUpForActivity();
        thenReturnFalseForUserNotSignedUpForActivity();
    }

    private User createTestUser(int userId, String firstName, String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserId(userId);
        return user;
    }

    private Activity createTestActivity(int activityId, String name, String description, LocalDate date, String location) {
        Activity activity = new Activity();
        activity.setName(name);
        activity.setActivityId(activityId);
        activity.setDescription(description);
        activity.setTimestamp(date);
        activity.setLocation(location);
        return activity;
    }

    private void givenUsersAreAvailable() throws Exception {
        User user = createTestUser(1, "Test", "User");
        Mockito.when(userDAO.createUser("Test", "User")).thenReturn(user);
    }

    private void whenGetUser1() throws Exception {
        User user = createTestUser(1, "Test", "User");
        Mockito.when(userDAO.getUser(1)).thenReturn(user);
    }

    private void whenGetAllUsers() throws Exception {
        User user = createTestUser(1, "Test", "User");
        Mockito.when(userDAO.getUsers()).thenReturn(List.of(user));
    }

    private void thenReturnUserNameForUser1() throws Exception {
        String userName = userService.getUserName(1);
        assertEquals("Test User", userName);
    }

    private void thenReturnAtLeastOneUser() throws Exception {
        List<User> users = userService.getUsers();
        assertFalse(users.isEmpty());
    }

    private void givenActivitiesAreAvailable() throws Exception {
        Activity activity = createTestActivity(1, "Test Activity", "Test Description", LocalDate.now(), "Test Location");
        Mockito.when(activityDAO.saveActivity(activity)).thenReturn(activity);
    }

    private void whenGetActivity1() throws Exception {
        Activity activity = createTestActivity(1, "Test Activity", "Test Description", LocalDate.now(), "Test Location");
        Mockito.when(activityDAO.getActivity(1)).thenReturn(activity);
    }

    private void thenReturnActivity1() throws Exception {
        Activity activity = activityService.getActivity(1);
        assertEquals("Test Activity", activity.getName());
        assertEquals("Test Description", activity.getDescription());
        assertEquals("Test Location", activity.getLocation());
        assertEquals(1, activity.getActivityId());
    }

    private void whenGetActivitiesForDate() throws Exception {
        Activity activity = createTestActivity(1, "Test Activity", "Test Description", LocalDate.now(), "Test Location");
        Mockito.when(activityDAO.getActivities()).thenReturn(List.of(activity));
    }

    private void whenGetUsersSignedUpForActivity() throws Exception {
        User user = createTestUser(1, "Test", "User");
        UserActivity userActivity = new UserActivity();
        userActivity.setUser(1);
        userActivity.setActivity(1);

        Mockito.when(userActivityDAO.getAllUserActivities()).thenReturn(List.of(userActivity));
        Mockito.when(userDAO.getUser(1)).thenReturn(user);
    }

    private void thenReturnAtLeastOneSignedUpUser() throws Exception {
        List<User> users = activityService.getUsersSignedUpForActivity(1);
        assertFalse(users.isEmpty());
    }

    private void whenGetActivitiesForUser() throws Exception {
        Activity activity = createTestActivity(1, "Test Activity", "Test Description", LocalDate.now(), "Test Location");
        UserActivity userActivity = new UserActivity();
        userActivity.setUser(1);
        userActivity.setActivity(1);

        Mockito.when(userActivityDAO.getAllUserActivities()).thenReturn(List.of(userActivity));
    }

    private void thenReturnAtLeastOneActivityForUser() throws Exception {
        List<Activity> activities = activityService.getSignedUpActivitiesForUser(1);
        assertFalse(activities.isEmpty());
    }

    private void givenActivitiesForSpecificDates(LocalDate testDate, LocalDate otherDate) throws Exception {
        Activity activity1 = createTestActivity(1, "Test Activity 1", "Test Description 1", testDate, "Test Location 1");
        Activity activity2 = createTestActivity(2, "Test Activity 2", "Test Description 2", otherDate, "Test Location 2");

        Mockito.when(activityDAO.getActivity(1)).thenReturn(activity1);
        Mockito.when(activityDAO.getActivity(2)).thenReturn(activity2);
        Mockito.when(activityDAO.getActivities()).thenReturn(List.of(activity1, activity2));
    }

    private void whenUserSignedUpForActivitiesOnDifferentDates() throws Exception {
        UserActivity userActivity1 = new UserActivity();
        userActivity1.setUser(1);
        userActivity1.setActivity(1);

        UserActivity userActivity2 = new UserActivity();
        userActivity2.setUser(1);
        userActivity2.setActivity(2);

        Mockito.when(userActivityDAO.getAllUserActivities()).thenReturn(List.of(userActivity1, userActivity2));
    }

    private void thenReturnOnlyActivitiesForSpecificDate(LocalDate date) throws Exception {
        List<Activity> activities = activityService.getSignedUpActivitiesForUserForDate(1, date);

        assertFalse(activities.isEmpty());
        assertEquals(1, activities.size());
        assertEquals("Test Activity 1", activities.getFirst().getName());
        assertEquals(date, activities.getFirst().getTimestamp());
    }

    private void whenUserSignedUpForActivity() throws Exception {
        UserActivity userActivity = new UserActivity();
        userActivity.setUser(1);
        userActivity.setActivity(1);

        Mockito.when(userActivityDAO.getAllUserActivities()).thenReturn(List.of(userActivity));
    }

    private void thenReturnTrueForUserSignedUpForActivity() throws Exception {
        boolean isSignedUp = activityService.isUserSignedUpForActivity(1, 1);
        assertTrue(isSignedUp);
    }

    private void whenUserNotSignedUpForActivity() throws Exception {
        Mockito.when(userActivityDAO.getAllUserActivities()).thenReturn(List.of());
    }

    private void thenReturnFalseForUserNotSignedUpForActivity() throws Exception {
        boolean isSignedUp = activityService.isUserSignedUpForActivity(1, 1);
        assertFalse(isSignedUp);
    }
}
