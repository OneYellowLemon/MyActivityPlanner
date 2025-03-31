package com.myactivityplanner.enterprise.dao;

import com.myactivityplanner.enterprise.dto.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserDAOStub implements IUserDAO {

    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<>();
    private final AtomicInteger userIdCounter = new AtomicInteger(1);  // Tracks the next available userId

    @Override
    public User createUser(String firstName, String lastName) {
        if (firstName == null || firstName.trim().isEmpty() || lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name and last name cannot be null or empty");
        }

        User user = new User();
        user.setUserId(userIdCounter.getAndIncrement());  // Get and increment the userId
        user.setFirstName(firstName);
        user.setLastName(lastName);
        users.put(user.getUserId(), user);
        return user;
    }

    @Override
    public Optional<User> getUserById(int userId) {
        return Optional.ofNullable(users.get(userId));  // Returns an Optional instead of null
    }
}
