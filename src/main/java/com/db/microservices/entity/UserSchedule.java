package com.db.microservices.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userschedule")
public class UserSchedule {

	@Id
	@Column(name = "USER_NAME")
	private String username;
	
	@Column(name = "START_TIME")
	private String startTime;
	
	@Column(name = "END_TIME")
	private String endTime;
	
	@Column(name = "BREAK_TIME")
	private int interval;

	public UserSchedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserSchedule(String username, String startTime, String endTime, int interval) {
		super();
		this.username = username;
		this.startTime = startTime;
		this.endTime = endTime;
		this.interval = interval;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	@Override
	public String toString() {
		return "UserSchedule [username=" + username + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", interval=" + interval + "]";
	}

	
	
	
}
