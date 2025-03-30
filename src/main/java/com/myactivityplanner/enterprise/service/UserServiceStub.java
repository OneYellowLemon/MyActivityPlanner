package com.myactivityplanner.enterprise.service;

import com.myactivityplanner.enterprise.dto.User;
import org.springframework.stereotype.Service;

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
    public User getUserName(int userId) {
        return "TestUser Name";
    }
}
