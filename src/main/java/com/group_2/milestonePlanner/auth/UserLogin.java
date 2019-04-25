package com.group_2.milestonePlanner.auth;

import com.group_2.milestonePlanner.dao.DAO;
import com.group_2.milestonePlanner.model.User;
import com.group_2.milestonePlanner.repo.UserList;
import lombok.NonNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserLogin  implements IUserLogin{
	static final Logger LOG = LoggerFactory.getLogger(UserLogin.class);
	static UserList userList = DAO.loadUsers();


	public static synchronized boolean login(@NonNull String userName, @NonNull String password) {
		String storedHash = userList.getUserPasswordHash(userName);
		return storedHash != null && PasswordHash.validatePassword(password, userList.getUserPasswordHash(userName));
	}

	public static synchronized boolean register(@NonNull String userName, @NonNull String password, String email) {
		String current = userList.getUserPasswordHash(userName);
		if (current != null) {
			return false;
		}
		try {
			String hash = PasswordHash.createHash(password);
			DAO.addUser(new User(userName, hash, email));
			userList = DAO.loadUsers();
			return true;
		}
		catch(Exception e){
			LOG.error("Can't hash password <" +password+">:" +e.getMessage());
			return false;
		}
	}
}
