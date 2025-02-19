package com.myactivityplanner.enterprise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
