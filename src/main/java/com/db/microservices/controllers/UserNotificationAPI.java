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
import com.db.microservices.repository.UserInterestsDAO;
import com.db.microservices.repository.UserNotificationDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping(value = "usernotification")
public class UserNotificationAPI {

	@Autowired
	private UserNotificationDAO userNotificationDAO;
	
	@Autowired
	private UserInterestsDAO userInterestsDAO;

	@PostMapping
	public ResponseEntity<?> createNotification(@RequestBody UserNotification user) {
		userNotificationDAO.save(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	public String getRandomElement(List<String> list)
    {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
	
	@GetMapping(value = "/{username}")
	public ResponseEntity<?> getNotification(@PathVariable String username) {
		try {
			if(username!=null && username.length()!=0) {
				List<String> interests = userInterestsDAO.findByUsername(username);
				if(interests.size()==0) {
					throw new NullPointerException();
				}
				String interest = getRandomElement(interests);
				List<String> notifications =  userNotificationDAO.findByInterestName(interest);
				if(notifications.size()==0) {
					throw new NullPointerException();
				}
				String notification = getRandomElement(notifications);
				Map<String,String> map= new HashMap<>();
				map.put("interest",interest);
				map.put("notification", notification);
				return new ResponseEntity<>(map, HttpStatus.OK);
			}
			else {
				throw new IllegalArgumentException();
			}
		}catch(Exception e) {
			return new ResponseEntity<>("EmptyArguments", HttpStatus.NOT_FOUND);
		}
		
	}

	/*@GetMapping(value = "/{id}")
	public @ResponseBody UserNotification createUser(@PathVariable Long id) {
		return userNotificationDAO.findById(id).get();
	}*/

}
