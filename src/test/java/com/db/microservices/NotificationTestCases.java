package com.db.microservices;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.db.microservices.controllers.UserInterestsAPI;
import com.db.microservices.controllers.UserNotificationAPI;
import com.db.microservices.entity.UserAllInterests;

@SpringBootTest
public class NotificationTestCases {

	@Autowired
	UserNotificationAPI userNotificationAPI ;
	
	@Test
	void usernameEmptyTest() {
		assertTrue(new ReflectionEquals("EmptyArguments").matches(userNotificationAPI.getNotification("").getBody()));
	}
}
