package com.myactivityplanner.enterprise.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceStub implements IUserService {

    @Override
    public boolean createUser(String firstName, String lastName) {
        return true;
    }

    @Override
    public String getUserName(int userId) {
        return "TestUser Name";
    }
}
