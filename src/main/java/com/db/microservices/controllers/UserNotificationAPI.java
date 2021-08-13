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

import com.db.microservices.entity.UserNotification;
import com.db.microservices.repository.UserNotificationDAO;

import org.springframework.beans.factory.annotation.*;


@RestController
@RequestMapping(value = "usernotification")
public class UserNotificationAPI {

	@Autowired
	private UserNotificationDAO userNotificationDAO;

	@PostMapping
	public @ResponseBody UserNotification createUser(@RequestBody UserNotification user) {
		userNotificationDAO.save(user);
		return user;
	}

	@GetMapping(value = "/{id}")
	public @ResponseBody UserNotification createUser(@PathVariable Long id) {
		return userNotificationDAO.findById(id).get();
	}

}
