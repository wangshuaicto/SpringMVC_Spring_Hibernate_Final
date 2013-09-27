package com.shuai.web.dao;

import java.util.List;

import com.shuai.web.entity.User;

public interface IUserDao {
	public void addUser(User user);
	public List<User> getAllUser();
	public boolean deleteUser(String id);
	/*
	 * 查询单个实体
	 */
	public User getSingleUser(String id);
	
	//更新操作
	public boolean updateUser(User user);
}
