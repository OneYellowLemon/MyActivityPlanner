package com.myactivityplanner.enterprise.dao;

import com.myactivityplanner.enterprise.dto.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Profile("test")
public class UserDAOStub implements IUserDAO {
    Map<Integer, User> users = new HashMap<>();

    @Override
    public boolean createUser(String firstName, String lastName) {
        User user = new User();
        user.setUserId(users.size() + 1);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        users.put(user.getUserId(), user);
        return true;
    }

    @Override
    public User getUser(int userId) {
        return users.get(userId);
    }
}
