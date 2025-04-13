package com.myactivityplanner.enterprise;

import com.myactivityplanner.enterprise.service.IActivityService;
import com.myactivityplanner.enterprise.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController {

    @Autowired
    IActivityService activityService;

    @Autowired
    IUserService userService;

    /**
     * Handle the root (/) endpoint and return starting page
     * @return index.html
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * Handle the AvailableActivities endpoint and return the AvailableActivities page
     * @return AvailableActivities.html
     */
    @RequestMapping("AvailableActivities")
    public String AvailableActivities() {
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
    public String AdminAccount() {
        return "AdminAccount";
    }
}
