package com.myactivityplanner.enterprise;

import com.myactivityplanner.enterprise.dto.User;
import com.myactivityplanner.enterprise.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    
    @Autowired
    IUserService userService;

    /**
     * API endpoint to create a new user
     * @param user The user to create
     * @return True if the user was created successfully, otherwise false
     */
    @PostMapping("api/user")
    @ResponseBody
    public boolean createUser(@RequestBody User user) {
        return userService.createUser(user.getFirstName(), user.getLastName());
    }

    /**
     * API endpoint to get the name of a user by ID
     * @param userId The ID of the user to get
     * @return The name of the user with the specified ID
     */
    @GetMapping("api/user/{userId}")
    @ResponseBody
    public String getUserName(@PathVariable int userId) {
        return userService.getUserName(userId);
    }
}