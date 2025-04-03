package com.myactivityplanner.enterprise.dao;

import com.myactivityplanner.enterprise.dto.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Integer> {

}
