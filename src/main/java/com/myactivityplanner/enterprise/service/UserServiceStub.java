package com.myactivityplanner.enterprise.service;

import com.myactivityplanner.enterprise.dto.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceStub implements IUserService {

    @Override
    public User createUser(String firstName, String lastName) {
        User newUser = new User();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        return newUser;
    }

    @Override
    public String getUserName(int userId) {
        return "TestUser Name";
    }

    @Override
    public List<User> getUsers() {
        User user1 = new User();
        user1.setFirstName("John");
        user1.setLastName("Doe");

        User user2 = new User();
        user2.setFirstName("Jane");
        user2.setLastName("Doe");

        return List.of(user1, user2);
    }
}
