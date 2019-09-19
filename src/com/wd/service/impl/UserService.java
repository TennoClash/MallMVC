package com.wd.service.impl;

import com.wd.po.User;
import com.wd.service.IUserService;

import java.util.List;
import java.util.Map;

import com.wd.dao.IUserDao;
import com.wd.dao.impl.*;

public class UserService implements IUserService {
	IUserDao userDao;
	
	public UserService() {
		super();
		userDao = new UserDao();
	}

	@Override
	public boolean addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public User getUserByNameAndPwd(String username, String password) {
		return userDao.getUserByNameAndPwd(username, password);
	}

	@Override
	public List<Map<String, String>> queryUserByPage(int cpage, int pagesize, String username) {
		return userDao.queryUserByPage(cpage, pagesize, username);
	}

	@Override
	public int queryUserCount(String username) {
		return userDao.queryUserCount(username);
	}

	@Override
	public boolean deleteUser(User user) {
		return userDao.deleteUser(user);
	}

	@Override
	public boolean updateUserinfo(User user) {
		return userDao.updateUserinfo(user);
		
	}

	@Override
	public Map<String, String> queryNewsDetail(String user_id) {
		return userDao.queryNewsDetail(user_id);
	}

	@Override
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}


}
