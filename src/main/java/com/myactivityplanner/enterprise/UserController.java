package com.myactivityplanner.enterprise;

import com.myactivityplanner.enterprise.dto.User;
import com.myactivityplanner.enterprise.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    
    @Autowired
    IUserService userService;

    /**
     * API endpoint to create a new user
     * @param user The user to create
     * @return The created user
     */
    @PostMapping("api/user")
    @ResponseBody
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.createUser(user.getFirstName(), user.getLastName()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * API endpoint to get the name of a user by ID
     * @param userId The ID of the user to get
     * @return The name of the user with the specified ID
     */
    @GetMapping("api/user/{userId}")
    @ResponseBody
    public ResponseEntity<User> getUserName(@PathVariable int userId) {
        try {
            return ResponseEntity.ok(userService.getUserName(userId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}