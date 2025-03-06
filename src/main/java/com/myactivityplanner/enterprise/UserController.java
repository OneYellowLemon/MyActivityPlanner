package com.myactivityplanner.enterprise;

import com.myactivityplanner.enterprise.dto.Activity;
import com.myactivityplanner.enterprise.dto.User;
import com.myactivityplanner.enterprise.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    
    @Autowired
    IUserService userService;
    
    @RequestMapping
    public String index() {
        return "index";
    }

    @PutMapping("api/user")
    public boolean createUser(@PathVariable String firstName, @PathVariable String lastName) {
        return userService.createUser(firstName, lastName);
    }

    @GetMapping("api/user/{userId}")
    public String getUserName(@PathVariable int userId) {
        return userService.getUserName(userId);
    }
}