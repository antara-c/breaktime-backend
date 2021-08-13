package com.db.microservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userinterests")
public class UserInterests {
	@Id
	private Long id;
	@Column(name = "USER_NAME")
	private String username;
	
	@Column(name = "INTEREST_NAME") //Username is gmail id
	private String interestname;
	
	
	
	public String getInterestname() {
		return interestname;
	}
	public void setInterestname(String interestname) {
		this.interestname = interestname;
	}
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

