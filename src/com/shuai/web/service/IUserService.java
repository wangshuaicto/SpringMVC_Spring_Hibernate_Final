package com.shuai.web.service;

import java.util.List;

import com.shuai.web.entity.User;

public interface IUserService {

	public void addUser(User user);
	
	public List<User> getAllUser();
	
	public boolean deleteUser(String id);
	
	public User getSingleUser(String id);
	
	public boolean updateUser(User user);
}
