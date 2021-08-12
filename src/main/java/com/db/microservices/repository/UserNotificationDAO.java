package com.db.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.microservices.entity.UserNotification;

public interface UserNotificationDAO extends JpaRepository<UserNotification, Long> {

}
