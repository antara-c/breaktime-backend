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

import com.db.microservices.entity.UserNotification;
import com.db.microservices.entity.UserSchedule;
import com.db.microservices.repository.UserInterestsDAO;
import com.db.microservices.repository.UserNotificationDAO;
import com.db.microservices.repository.UserScheduleDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins ="",allowedHeaders = "")
@RestController
@RequestMapping(value = "usernotification")
public class UserNotificationAPI {

	@Autowired
	private UserNotificationDAO userNotificationDAO;
	
	@Autowired
	private UserInterestsDAO userInterestsDAO;
	 
	@Autowired
	private UserScheduleDAO userScheduleDAO;

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
				
				String interest="";
				if(interests.size()==0) {
					//send default notification
					interest="default";
					//throw new NullPointerException();
				}
				
				interest = getRandomElement(interests);
				
				//System.out.println(interest);
				List<String> notifications =  userNotificationDAO.findByInterestName(interest);
				//System.out.println(notifications);
				if(notifications.size()==0) {
					throw new NullPointerException();
				}
				String notification = getRandomElement(notifications);
				UserSchedule schedule=userScheduleDAO.findById(username).get();
				//System.out.println(schedule);
				Map<String,String> map= new HashMap<>();
				map.put("interest",interest);
				map.put("notification", notification);
				map.put("startTime", schedule.getStartTime());
				map.put("endTime", schedule.getEndTime());
				map.put("interval", Integer.toString(schedule.getInterval()));
				return new ResponseEntity<>(map, HttpStatus.OK);
			}
			else {
				throw new IllegalArgumentException();
			}
		}catch(Exception e) {
			System.out.println("Exception"+e);
			return new ResponseEntity<>("EmptyArguments", HttpStatus.NOT_FOUND);
		}
		
	}

	/*@GetMapping(value = "/{id}")
	public @ResponseBody UserNotification createUser(@PathVariable Long id) {
		return userNotificationDAO.findById(id).get();
	}*/

}
