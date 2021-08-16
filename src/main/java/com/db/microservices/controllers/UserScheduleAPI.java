package com.db.microservices.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.microservices.entity.UserAuthentication;
import com.db.microservices.entity.UserSchedule;
import com.db.microservices.repository.UserScheduleDAO;

@CrossOrigin(origins ="",allowedHeaders = "")
@RestController
@RequestMapping(value = "userschedule")
public class UserScheduleAPI {

	@Autowired
	private UserScheduleDAO userScheduleDAO;
	
	@PostMapping
	public ResponseEntity<?> createSchedule(@RequestBody UserSchedule schedule) {
		try {
			if(schedule.getUsername()!=""&& schedule.getUsername()!=null && schedule.getStartTime()!="" && schedule.getStartTime()!=null && schedule.getEndTime()!="" && schedule.getEndTime()!=null) {
				userScheduleDAO.save(schedule);
				return new ResponseEntity<>(schedule, HttpStatus.OK);
			}
			else{
				throw new IllegalArgumentException();
			}
		}catch(Exception e) {
			return new ResponseEntity<>("EmptyArguments", HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(value = "/{username}")
	public ResponseEntity<?> getSchedule(@PathVariable String username) {
		try {
			if(username!="" && username.length()!=0) {
				UserSchedule schedule=userScheduleDAO.findById(username).get();
				return new ResponseEntity<>(schedule, HttpStatus.OK);
				
			}else {
				throw new IllegalArgumentException();
			}
		}catch(Exception e) {
			//System.out.println(e);
			return new ResponseEntity<>("EmptyArguments", HttpStatus.NOT_FOUND);
		}
		
	}
}
