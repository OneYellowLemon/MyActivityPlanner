package com.myactivityplanner.enterprise.dao;

import com.myactivityplanner.enterprise.dto.UserActivity;
import org.springframework.data.repository.CrudRepository;

public interface IUserActivityRepository extends CrudRepository<UserActivity, Integer> {
}
