package com.db.microservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.db.microservices.entity.UserInterests;

public interface UserInterestsDAO extends JpaRepository<UserInterests,String> {

	@Query("SELECT interestname FROM UserInterests u  WHERE u.username = :userName")
    public List<String> findByUsername(@Param("userName") String userName);
}
