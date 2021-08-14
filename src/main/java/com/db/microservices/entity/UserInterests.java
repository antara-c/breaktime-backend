package com.db.microservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userinterests")
public class UserInterests {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name = "USER_NAME")
	private String username;
	
	@Column(name = "INTEREST_NAME") //Username is gmail id
	private String interestname;
	
	
	
	public UserInterests() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public UserInterests(int id, String username, String interestname) {
		super();
		this.id = id;
		this.username = username;
		this.interestname = interestname;
	}
	

	

	public UserInterests(String username, String interestname) {
		super();
		this.username = username;
		this.interestname = interestname;
	}


	public String getInterestname() {
		return interestname;
	}
	public void setInterestname(String interestname) {
		this.interestname = interestname;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}

