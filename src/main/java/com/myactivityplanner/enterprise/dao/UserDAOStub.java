package com.myactivityplanner.enterprise.dao;

import com.myactivityplanner.enterprise.dto.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDAOStub implements IUserDAO {
    Map<Integer, User> users = new HashMap<>();

    @Override
    public User createUser(String firstName, String lastName) {
        User user = new User();
        user.setUserId(users.size() + 1);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        users.put(user.getUserId(), user);
        return user;
    }

    @Override
    public User getUser(int userId) {
        return users.get(userId);
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }
}
