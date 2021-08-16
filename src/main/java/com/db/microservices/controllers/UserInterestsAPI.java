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

import com.db.microservices.entity.UserAllInterests;
import com.db.microservices.entity.UserAuthentication;
import com.db.microservices.entity.UserInterests;
import com.db.microservices.repository.UserInterestsDAO;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

@RestController
@RequestMapping(value = "userinterests")
public class UserInterestsAPI {

	@Autowired
	private UserInterestsDAO userInterestsDAO;

	@PostMapping
	public ResponseEntity<?> createInterests(@RequestBody UserAllInterests user) {
		/*System.out.println(user);
		ArrayList<UserInterests> abc=user.getUserInterests();
		System.out.println(abc);
		userInterestsDAO.saveAll(abc);
		return new ResponseEntity<>("Saved", HttpStatus.OK);
		*/
		try {
			if(user.getUsername()!=null && user.getUsername().length()!=0 && user.getInterestname().size()!=0) {
				for (int i = 0; i < user.getInterestname().size(); i++) {
					//System.out.println("Interests : "+ user.getInterestname().get(i));
					UserInterests abc = new UserInterests(user.getUsername(),user.getInterestname().get(i));
					userInterestsDAO.save(abc);
				
				}
			}else {
				throw new IllegalArgumentException();
			}
			
			
			return new ResponseEntity<>("Saved", HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>("EmptyArguments", HttpStatus.NOT_FOUND);
		}
		
	}


	@GetMapping(value = "/{userName}")
	public ResponseEntity<?> getInterests(@PathVariable String userName) {
		try {
			if(userName!= null && userName.length()!=0) {
				List<String> interests = userInterestsDAO.findByUsername(userName);
				return new ResponseEntity<>(interests, HttpStatus.OK);
				
			}else {
				throw new IllegalArgumentException();
			}
		}catch(Exception e) {
			return new ResponseEntity<>("EmptyArguments", HttpStatus.NOT_FOUND);
		}
		//System.out.println(userName);
		
		//return userInterestsDAO.findByUsername(userName);
	}

}
