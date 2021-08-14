package com.db.microservices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.db.microservices.controllers.UserAuthenticationAPI;
import com.db.microservices.entity.UserAuthentication;
import com.db.microservices.repository.UserAuthenticationDAO;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class LoginTests {
	
	@Autowired
	UserAuthenticationAPI user;

	@MockBean
	UserAuthenticationDAO userAuthenticationDAO;
	
	@Test
	void usernameEmptyTest() {
		UserAuthentication emptyUserNameUser = new UserAuthentication("","firstname","lastname");
		//emptyUserNameUser.setUsername();
		//System.out.println(user.createUser(emptyUserNameUser).getBody());
		assertTrue(new ReflectionEquals("EmptyArguments").matches(user.createUser(emptyUserNameUser).getBody()));
	}
	
	@Test
	void firstnameEmpty() {
		UserAuthentication emptyUserNameUser = new UserAuthentication("username","","lastname");
		//emptyUserNameUser.setUsername();
		//System.out.println(user.createUser(emptyUserNameUser).getBody());
		assertTrue(new ReflectionEquals("EmptyArguments").matches(user.createUser(emptyUserNameUser).getBody()));
	}
	
	@Test
	void lastnameEmpty() {
		UserAuthentication emptyUserNameUser = new UserAuthentication("username","firstname","");
		//emptyUserNameUser.setUsername();
		//System.out.println(user.createUser(emptyUserNameUser).getBody());
		assertTrue(new ReflectionEquals("EmptyArguments").matches(user.createUser(emptyUserNameUser).getBody()));
	}
	
	@Test
	void lastnameNull() {
		UserAuthentication emptyUserNameUser = new UserAuthentication("username","firstname",null);
		//emptyUserNameUser.setUsername(null);
		//System.out.println(user.createUser(emptyUserNameUser).getBody());
		assertTrue(new ReflectionEquals("EmptyArguments").matches(user.createUser(emptyUserNameUser).getBody()));
	}
	
	@Test
	void usernameNull() {
		UserAuthentication emptyUserNameUser = new UserAuthentication(null,"firstname","lastname");
		//emptyUserNameUser.setUsername();
		//System.out.println(user.createUser(emptyUserNameUser).getBody());
		assertTrue(new ReflectionEquals("EmptyArguments").matches(user.createUser(emptyUserNameUser).getBody()));
	}
	
	@Test
	void firstnameNull() {
		UserAuthentication emptyUserNameUser = new UserAuthentication("username",null,"lastname");
		//emptyUserNameUser.setUsername();
		//System.out.println(user.createUser(emptyUserNameUser).getBody());
		assertTrue(new ReflectionEquals("EmptyArguments").matches(user.createUser(emptyUserNameUser).getBody()));
	}
	
	@Test
	void userCorrect() {
		UserAuthentication user_new = new UserAuthentication("username","firstname","lastname");
		//emptyUserNameUser.setUsername();
		//System.out.println(user.createUser(user_new).getBody());
		assertTrue(new ReflectionEquals(user_new).matches(user.createUser(user_new).getBody()));
	}
	
	/*@Test
	void userCorrectFetchUser() {
		UserAuthentication user_new = new UserAuthentication("abc","gargi","k");
		System.out.println("**********");
		Mockito.when(userAuthenticationDAO.findById("abc").get()).thenReturn(user_new);
		System.out.println("$$$$$$$$$$$$$$$$");
		System.out.println(user.getUser("abc").getBody());
		assertTrue(new ReflectionEquals(user_new).matches(user.getUser("abc").getBody()));
	}*/
	
	@Test
	void usernameEmptyFetch() {
		
		assertTrue(new ReflectionEquals(new UserAuthentication()).matches(user.getUser("").getBody()));
	}
	
	@Test
	void usernameNullFetch() {
		
		assertTrue(new ReflectionEquals(new UserAuthentication()).matches(user.getUser(null).getBody()));
	}

}
