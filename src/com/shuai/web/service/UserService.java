package com.shuai.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuai.web.dao.IUserDao;
import com.shuai.web.entity.User;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private IUserDao userDao;
	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}

	@Override
	public boolean deleteUser(String id) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(id);
	}
	
	@Override
	public User getSingleUser(String id) {
		// TODO Auto-generated method stub
		return userDao.getSingleUser(id);
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

}
