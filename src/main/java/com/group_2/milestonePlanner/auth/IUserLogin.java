package com.group_2.milestonePlanner.auth;

public interface IUserLogin {
	boolean login(String userName, String password);
	boolean register(String userName, String password);
}
