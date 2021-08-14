package com.db.microservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userauthentication")
public class UserAuthentication {
	@Id
	@Column(name = "USER_NAME") //Username is gmail id
	private String username;
	@Column(name = "FIRST_NAME") //Username is gmail id
	private String firstname;
	@Column(name = "LAST_NAME") //Username is gmail id
	private String lastname;
	//@Column(name = "PASS_WORD")
	//private String password;
	/*
	@Column(name = "id") //Username is gmail id
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}*/
	
	
	public String getFirstname() {
		return firstname;
	}
	public UserAuthentication(String username, String firstname, String lastname) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	public UserAuthentication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	
	
	/*public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}*/
	public void setUsername(String username) {
		this.username = username;
	}
}

