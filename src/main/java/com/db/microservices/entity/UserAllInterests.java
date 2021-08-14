package com.db.microservices.entity;

import java.util.ArrayList;

public class UserAllInterests {

	private String username;
	private ArrayList<String> interestname;
	public UserAllInterests() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserAllInterests(String username, ArrayList<String> interestname) {
		super();
		this.username = username;
		this.interestname = interestname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ArrayList<String> getInterestname() {
		return interestname;
	}
	public void setInterestname(ArrayList<String> interestname) {
		this.interestname = interestname;
	}
	@Override
	public String toString() {
		return "UserAllInterests [username=" + username + ", interestname=" + interestname + "]";
	}
	
	/*public ArrayList<UserInterests> getUserInterests(){
		
		ArrayList<UserInterests> userinterest = new ArrayList<UserInterests>();
		for (int i = 0; i < this.getInterestname().size(); i++) {
			System.out.println(i+" "+userinterest);
			UserInterests user = new UserInterests();
			userinterest.add(user);
		}
            
		return userinterest;
	}
	*/

}
