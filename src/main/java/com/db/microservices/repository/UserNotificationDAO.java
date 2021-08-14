package com.db.microservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.db.microservices.entity.UserNotification;

public interface UserNotificationDAO extends JpaRepository<UserNotification, Long> {

	@Query("SELECT notification FROM UserNotification u  WHERE u.interestname = :interestName")
    public List<String> findByInterestName(String interestName);
}
