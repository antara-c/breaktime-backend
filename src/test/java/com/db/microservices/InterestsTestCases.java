package com.db.microservices;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.db.microservices.controllers.UserInterestsAPI;
import com.db.microservices.entity.UserAllInterests;
import com.db.microservices.entity.UserAuthentication;
import com.db.microservices.entity.UserInterests;

@SpringBootTest
public class InterestsTestCases {

	@Autowired
	UserInterestsAPI userinterestsAPI ;
	
	@Test
	void usernameEmptyTest() {
		ArrayList<String> interests = new ArrayList<String> ();
		interests.add("interest1");
		UserAllInterests user = new UserAllInterests("",interests);
		assertTrue(new ReflectionEquals("EmptyArguments").matches(userinterestsAPI.createInterests(user).getBody()));
	}
	
	@Test
	void interestsEmptyTest() {
		ArrayList<String> interests = new ArrayList<String> ();
		UserAllInterests user = new UserAllInterests("username",interests);
		assertTrue(new ReflectionEquals("EmptyArguments").matches(userinterestsAPI.createInterests(user).getBody()));
	}
}
