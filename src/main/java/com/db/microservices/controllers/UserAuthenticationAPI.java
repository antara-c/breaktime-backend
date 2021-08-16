package com.db.microservices.controllers;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins ="*",allowedHeaders = "*")
@RestController
@RequestMapping(value = "userauthentication")
public class UserAuthenticationAPI {

	@Autowired
	private UserAuthenticationDAO userAuthenticationDAO;

	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody UserAuthentication user) {
		
		try {
			if(user.getUsername()!= null && user.getUsername().length()!=0 && user.getFirstname()!=null && user.getFirstname().length()!=0 && user.getLastname()!=null && user.getLastname().length()!=0) {
				userAuthenticationDAO.save(user);
				return new ResponseEntity<>(user, HttpStatus.OK);
			}
			else {
				throw new IllegalArgumentException();
			}
		}catch(Exception e) {
			return new ResponseEntity<>("EmptyArguments", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/{username}")
	public ResponseEntity<?> getUser(@PathVariable String username) {
		
		try {
			if(username!= null && username.length()!=0) {
				UserAuthentication user = userAuthenticationDAO.findById(username).get();
				System.out.println(user);
				return new ResponseEntity<>(user, HttpStatus.OK);
			}
			else {
				throw new IllegalArgumentException();
			}
		}catch(Exception e) {
			return new ResponseEntity<>(new UserAuthentication(), HttpStatus.NOT_FOUND);
		}
		
	}

}
