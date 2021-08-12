package com.db.microservices.controllers;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.db.microservices.entity.UserAuthentication;
import com.db.microservices.repository.UserAuthenticationDAO;

import org.springframework.beans.factory.annotation.*;


@RestController
@RequestMapping(value = "user")
public class UserAuthenticationAPI {

	@Autowired
	private UserAuthenticationDAO userAuthenticationDAO;

	@PostMapping
	public @ResponseBody UserAuthentication createUser(@RequestBody UserAuthentication user) {
		userAuthenticationDAO.save(user);
		return user;
	}

	@GetMapping(value = "/{id}")
	public @ResponseBody UserAuthentication createUser(@PathVariable Long id) {
		return userAuthenticationDAO.findById(id).get();
	}

}
