package com.group_2.milestonePlanner.model;

public class User {
	private String userName;
	private String passwordHash;
	private String email;
	private int user_id;

	private static int next_user_id = 1;

	public User(String userName, String passwordHash) {
		this.userName = userName;
		this.passwordHash = passwordHash;
		this.user_id = next_user_id;
		next_user_id++;
	}

	public User(String userName, String passwordHash, String email){
		this.userName = userName;
		this.passwordHash = passwordHash;
		this.email = email;
		this.user_id = next_user_id;
		next_user_id++;
	}

	public User(String userName, String passwordHash, String email, int user_id) {
		this.userName = userName;
		this.passwordHash = passwordHash;
		this.email = email;
		this.user_id = user_id;
	}

	public User(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
