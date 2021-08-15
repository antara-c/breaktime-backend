package com.db.microservices;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.db.microservices.controllers.UserScheduleAPI;

@SpringBootTest
//@RunWith(SpringRunner.class)
//@RunWith(MockitoJUnitRunner.class)
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = { SpringTestConfiguration.class })
public class ScheduleTesting {
	
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
