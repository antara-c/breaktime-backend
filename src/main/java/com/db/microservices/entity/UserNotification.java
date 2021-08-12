package com.db.microservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserNotification {
	@Id
	private Long id;
	@Column(name = "USER_NAME")
	private String username;
	
	@Column(name = "FIRST_NAME") //Username is gmail id
	private String firstname;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	@Column(name = "INTEREST_NAME") //Username is gmail id
	private String interestname;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
}

