package com.group_2.milestonePlanner.dao;

import com.group_2.milestonePlanner.auth.PasswordHash;
import com.group_2.milestonePlanner.model.User;
import com.group_2.milestonePlanner.repo.UserList;

import java.util.ArrayList;

public class UserDAO {
	public static UserList userList;

	public UserDAO() {
		userList = new UserList();
	}

	public static UserList getUsers(){
		String hash = PasswordHash.createHash("morema");
		User morema = new User("morema", "morema");
		userList.put(morema);
		return userList;
	}
}
