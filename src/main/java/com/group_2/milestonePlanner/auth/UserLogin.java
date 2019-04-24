package com.group_2.milestonePlanner.auth;

import com.group_2.milestonePlanner.dao.UserDAO;
import com.group_2.milestonePlanner.repo.UserList;
import lombok.NonNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserLogin  implements IUserLogin{
	static final Logger LOG = LoggerFactory.getLogger(UserLogin.class);
	static UserList userList = UserDAO.getUsers();


	public static synchronized boolean login(@NonNull String userName, @NonNull String password) {
		String storedHash = userList.get(userName);
		return storedHash != null && PasswordHash.validatePassword(password, userList.get(userName));
	}

	public static synchronized boolean register(@NonNull String userName, @NonNull String password, String email) {
		String current = userList.get(userName);
		if (current != null) {
			return false;
		}
		try {
			String hash = PasswordHash.createHash(password);
			userList.put(userName, hash, email);
			return true;
		}
		catch(Exception e){
			LOG.error("Can't hash password <" +password+">:" +e.getMessage());
			return false;
		}
	}
}
