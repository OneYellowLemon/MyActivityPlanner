package com.myactivityplanner.enterprise.dao;

import com.myactivityplanner.enterprise.dto.Activity;
import org.springframework.data.repository.CrudRepository;

public interface IActivityRepository extends CrudRepository<Activity, Integer> {

}
