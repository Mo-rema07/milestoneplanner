package com.group_2.milestonePlanner.repo;

import com.group_2.milestonePlanner.model.User;

import java.util.ArrayList;

public class UserList {
	ArrayList<User> list;

	public void put(String userName, String hash){
		User detail = new User(userName, hash);
		list.add(detail);
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