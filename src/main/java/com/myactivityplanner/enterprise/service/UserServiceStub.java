package com.myactivityplanner.enterprise.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("test")
public class UserServiceStub implements IUserService {

    @Override
    public boolean createUser(String firstName, String lastName) {
        return true;
    }

    @Override
    public String getUserName(int userId) {
        return "";
    }
}
