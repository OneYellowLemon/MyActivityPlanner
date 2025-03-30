package com.myactivityplanner.enterprise.service;

import com.myactivityplanner.enterprise.dao.IUserDAO;
import com.myactivityplanner.enterprise.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserDAO userDAO;
    @Override
    public User createUser(String firstName, String lastName) throws Exception {
        User newUser = new User();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        return newUser;
    }

    @Override
    public User getUserName(int userId) throws Exception {
        return userDAO.getUserName(userId);
    }
}
