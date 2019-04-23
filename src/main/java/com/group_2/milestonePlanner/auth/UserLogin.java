package com.group_2.milestonePlanner.auth;

import com.group_2.milestonePlanner.repo.UserList;
import lombok.NonNull;

import static org.eclipse.jetty.http.MultiPartParser.LOG;

public class UserLogin  implements IUserLogin{
	UserList userList = new UserList();
	@Override
	public synchronized boolean login(@NonNull String userName, @NonNull String password) {
		String storedHash = userList.get(userName);
		return storedHash != null && PasswordHash.validatePassword(password, userList.get(userName));
	}

	@Override
	public synchronized boolean register(@NonNull String userName, @NonNull String password) {
		String current = userList.get(userName);
		if (current != null) {
			return false;
		}
		try {
			String hash = PasswordHash.createHash(password);
			userList.put(userName, hash);
			return true;
		}
		catch(Exception e){
			LOG.info("Can't hash password <" +password+">:" +e.getMessage());
			return false;
		}
	}
}
