package com.myactivityplanner.enterprise.dao;

import com.myactivityplanner.enterprise.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository("userDAO")
public class UserDAO implements IUserDAO {

    @Autowired
    IUserRepository userRepository;

    @Override
    public User createUser(String firstName, String lastName) throws IOException {
        User newUser = new User();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        userRepository.save(newUser);
        return newUser;
    }

    @Override
    public User getUser(int userId) throws IOException {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public List<User> getUsers() throws IOException {
        return (List<User>) userRepository.findAll();
    }
}
