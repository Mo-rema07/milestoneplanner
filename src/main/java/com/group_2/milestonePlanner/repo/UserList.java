package com.group_2.milestonePlanner.repo;

import com.group_2.milestonePlanner.model.User;

import java.util.ArrayList;

public class UserList {
	ArrayList<User> list;

	public UserList() {
		this.list = new ArrayList<>();
	}

	public void put(String userName, String hash){
		User detail = new User(userName, hash);
		list.add(detail);
	}

	public void put(User user){
		list.add(user);
	}
	public String get(String userName){
		for (User det : list){
			if (det.getUserName().equals(userName)){
				return det.getPasswordHash();
			}
		}
		return null;
	}
}
