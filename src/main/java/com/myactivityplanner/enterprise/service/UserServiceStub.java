package com.myactivityplanner.enterprise.service;

import com.myactivityplanner.enterprise.dto.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("test")
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
}
