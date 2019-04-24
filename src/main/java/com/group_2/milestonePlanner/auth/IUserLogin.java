package com.group_2.milestonePlanner.auth;

public interface IUserLogin {
	static boolean login(String userName, String password) {
		return false;
	}

	static boolean register(String userName, String password, String email) {
		return false;
	}
}
