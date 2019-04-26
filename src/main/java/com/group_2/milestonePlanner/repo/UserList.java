package com.group_2.milestonePlanner.repo;

import com.group_2.milestonePlanner.model.User;

import java.util.ArrayList;

public class UserList {
	ArrayList<User> list;

	public UserList() {
		this.list = new ArrayList<>();
	}

	public void put(String userName, String hash, String email){
		User user = new User(userName, hash, email);
		list.add(user);
	}

	public void put(User user){
		list.add(user);
	}

	public String getUserPasswordHash(String userName){
		for (User user : list){
			if (user.getUserName().equals(userName)){
				return user.getPasswordHash();
			}
		}
		return null;
	}

	public User getUser(int id){
		for (User user : list){
			if (user.getUser_id() == id){
				return user;
			}
		}
		return null;
	}

	public  User getUser(String name){
		for (User user : list){
			if (user.getUserName().equals(name)){
				return user;
			}
		}
		return null;

	}

}
