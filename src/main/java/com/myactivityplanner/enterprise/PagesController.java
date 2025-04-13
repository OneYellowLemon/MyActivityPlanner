package com.myactivityplanner.enterprise;

import com.myactivityplanner.enterprise.dto.Activity;
import com.myactivityplanner.enterprise.dto.User;
import com.myactivityplanner.enterprise.service.IActivityService;
import com.myactivityplanner.enterprise.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PagesController {

    @Autowired
    IActivityService activityService;

    @Autowired
    IUserService userService;

    /**
     * Handle the root (/) endpoint and return login page
     * @return index.html
     */
    @RequestMapping("/")
    public String index(Model model, @RequestParam(required = false) Integer userId, @RequestParam(required = false) boolean invalidUser) {
        model.addAttribute("invalidUser", invalidUser);

        // Attempt to auto login if userId is provided
        if (userId != null) {
            try {
                return "redirect:/AvailableActivities?userId=" + userId;
            } catch (Exception e) {
                // Empty catch block (if auto login fails, just show normal login page)
            }
        }

        return "index";
    }

    /**
     * Handle the AvailableActivities endpoint and return the AvailableActivities page
     * @return AvailableActivities.html
     */
    @RequestMapping("AvailableActivities")
    public String AvailableActivities(Model model, @RequestParam(required = false) Integer userId) {
        try {
            // Redirect to login page if userId is null
            if (userId == null) {
                return "redirect:/";
            }

            // Ensure user is valid
            if (userService.getUserName(userId) == null) {
                return "redirect:/?invalidUser=true";
            }
        } catch (Exception e) {
            return "redirect:/error?message=" + e.getMessage();
        }
        return "AvailableActivities";
    }

    /**
     * Handle the PersonalActivities endpoint and return the PersonalActivities page
     * @return PersonalActivities.html
     */
    @RequestMapping("PersonalActivities")
    public String PersonalActivities() {
        return "PersonalActivities";
    }

    /**
     * Handle the AddOrRemoveActivity endpoint and return the AddOrRemoveActivity page
     * @return AddOrRemoveActivity.html
     */
    @RequestMapping("AddOrRemoveActivity")
    public String AddOrRemoveActivity() {
        return "AddOrRemoveActivity";
    }

    /**
     * Handle the AdminAccount endpoint and return the AdminAccount page
     * @return AdminAccount.html
     */
    @RequestMapping("AdminAccount")
    public String AdminAccount(Model model, @RequestParam(required = false) Integer editId) {
        try {
            // Check if we're in edit mode
            if (editId != null) {
                Activity activityToEdit = activityService.getActivity(editId);
                model.addAttribute("activityForm", activityToEdit);
                model.addAttribute("editMode", true);
            } else {
                // New activity mode (not editing)
                Activity activityForm = new Activity();
                model.addAttribute("activityForm", activityForm);
                model.addAttribute("editMode", false);
            }

            User userForm = new User();
            model.addAttribute("userForm", userForm);

            List<String> formattedUsers = new ArrayList<>();
            List<User> users = userService.getUsers();

            for (User user : users) {
                String userName = userService.getUserName(user.getUserId());
                formattedUsers.add(userName + " (ID: " + user.getUserId() + ")");
            }

            model.addAttribute("users", formattedUsers);

            LocalDate today = LocalDate.now();
            LocalDate tomorrow = today.plusDays(1);
            LocalDate day3 = today.plusDays(2);
            LocalDate day4 = today.plusDays(3);
            LocalDate day5 = today.plusDays(4);
            LocalDate day6 = today.plusDays(5);
            LocalDate day7 = today.plusDays(6);

            model.addAttribute("day3", day3);
            model.addAttribute("day4", day4);
            model.addAttribute("day5", day5);
            model.addAttribute("day6", day6);
            model.addAttribute("day7", day7);

            List<Activity> activitiesToday = activityService.getActivitiesForDate(LocalDate.now());
            List<Activity> activitiesTomorrow = activityService.getActivitiesForDate(tomorrow);
            List<Activity> activitiesDay3 = activityService.getActivitiesForDate(day3);
            List<Activity> activitiesDay4 = activityService.getActivitiesForDate(day4);
            List<Activity> activitiesDay5 = activityService.getActivitiesForDate(day5);
            List<Activity> activitiesDay6 = activityService.getActivitiesForDate(day6);
            List<Activity> activitiesDay7 = activityService.getActivitiesForDate(day7);
            model.addAttribute("activitiesToday", activitiesToday);
            model.addAttribute("activitiesTomorrow", activitiesTomorrow);
            model.addAttribute("activitiesDay3", activitiesDay3);
            model.addAttribute("activitiesDay4", activitiesDay4);
            model.addAttribute("activitiesDay5", activitiesDay5);
            model.addAttribute("activitiesDay6", activitiesDay6);
            model.addAttribute("activitiesDay7", activitiesDay7);
        } catch (Exception e) {
            return "redirect:/error?message=" + e.getMessage();
        }
        return "AdminAccount";
    }
}
