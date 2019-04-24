package com.group_2.milestonePlanner.dao;

import com.group_2.milestonePlanner.auth.PasswordHash;
import com.group_2.milestonePlanner.model.User;
import com.group_2.milestonePlanner.repo.UserList;


public class UserDAO {
	public static UserList userList = new UserList();

	public static UserList getUsers(){
		String hash = PasswordHash.createHash("morema");
		User morema = new User("morema", hash);
		userList.put(morema);
		return userList;
	}
}