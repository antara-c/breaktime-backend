package com.db.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.microservices.entity.UserAuthentication;

public interface UserAuthenticationDAO extends JpaRepository<UserAuthentication, Long> {

}
