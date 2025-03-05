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
        user.userId = users.size() + 1;
        user.firstName = firstName;
        user.lastName = lastName;
        users.put(user.userId, user);
        return true;
    }

    @Override
    public User getUser(int userId) {
        return users.get(userId);
    }
}
