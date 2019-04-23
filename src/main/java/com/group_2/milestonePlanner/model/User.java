package com.group_2.milestonePlanner.model;

public class User {
	String userName;
	String passwordHash;

	public User(String userName, String passwordHash) {
		this.userName = userName;
		this.passwordHash = passwordHash;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
}
