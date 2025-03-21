package com.myactivityplanner.enterprise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActivityController {

    /**
     * Handle the root (/) endpoint and return a start page
     * @return index.html
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("AvailableActivities")
    public String AvailableActivities() {
        return "AvailableActivities";
    }

    @RequestMapping("PersonalActivities")
    public String PersonalActivities() {
        return "PersonalActivities";
    }

    @RequestMapping("AddOrRemoveActivity")
    public String AddOrRemoveActivity() {
        return "AddOrRemoveActivity";
    }

    @RequestMapping("AdminAccount")
    public String AdminAccount() {
        return "AdminAccount";
    }
}
