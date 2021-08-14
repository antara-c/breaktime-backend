package com.db.microservices;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db.microservices.controllers.UserScheduleAPI;
import com.db.microservices.entity.UserAuthentication;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ScheduleTestCases {
	
	@Autowired
	UserScheduleAPI userScheduleAPI;

	@Test
	public void usernameEmpty() {

		assertTrue(new ReflectionEquals("EmptyArguments").matches(userScheduleAPI.getSchedule("").getBody()));

	}
	
	@Test
	public void usernameNull() {
		
		assertTrue(new ReflectionEquals("EmptyArguments").matches(userScheduleAPI.getSchedule(null).getBody()));
	}
	
}
