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

import com.db.microservices.entity.UserInterests;
import com.db.microservices.repository.UserInterestsDAO;

import org.springframework.beans.factory.annotation.*;
import java.util.*;

@RestController
@RequestMapping(value = "userinterests")
public class UserInterestsAPI {

	@Autowired
	private UserInterestsDAO userInterestsDAO;

	@PostMapping
	public @ResponseBody ArrayList<String> createUser(@RequestBody Map<String,ArrayList<String>> user) {
		//userInterestsDAO.save(user);
		userInterestsDAO.saveAll(user);
		return user;
	}

	@GetMapping(value = "/{id}")
	public @ResponseBody UserInterests createUser(@PathVariable Long id) {
		return userInterestsDAO.findById(id).get();
	}

}
