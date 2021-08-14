package com.db.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.microservices.entity.UserNotification;
import com.db.microservices.entity.UserSchedule;

public interface UserScheduleDAO extends JpaRepository<UserSchedule, String> {

}
