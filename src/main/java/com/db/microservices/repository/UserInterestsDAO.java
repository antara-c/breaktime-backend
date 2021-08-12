package com.db.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.microservices.entity.UserInterests;

public interface UserInterestsDAO extends JpaRepository<UserInterests, Long> {

}
