package com.db.microservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usernotification")
public class UserNotification {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	/*@Column(name = "USER_NAME")
	private String username;
	
	@Column(name = "FIRST_NAME") //Username is gmail id
	private String firstname;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}*/
	@Column(name = "INTEREST_NAME") //Username is gmail id
	private String interestname;
	
	@Column(name="NOTIFICATION_NAME")
	private String notification;
	
	public UserNotification() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserNotification(Long id, String interestname, String notification) {
		super();
		this.id = id;
		this.interestname = interestname;
		this.notification = notification;
	}
	
	

	public UserNotification(String interestname, String notification) {
		super();
		this.interestname = interestname;
		this.notification = notification;
	}

	
	public String getInterestname() {
		return interestname;
	}

	public void setInterestname(String interestname) {
		this.interestname = interestname;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserNotification [id=" + id + ", interestname=" + interestname + ", notification=" + notification + "]";
	}
	
	/*public void setUsername(String username) {
		this.username = username;
	}*/
	
	
}

