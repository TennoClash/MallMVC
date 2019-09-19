package com.wd.dao;

import java.util.List;
import java.util.Map;

import com.wd.po.User;
import com.wd.util.DBUtil;

public interface IUserDao {

	public boolean addUser(User user);
	
	public User getUserByNameAndPwd(String username, String password);
	
	public List<Map<String, String>> queryUserByPage(int cpage,int pagesize,String username);
	
	public int queryUserCount(String username);
	
	public boolean deleteUser(User user);
	
	public boolean updateUserinfo(User user);
	
	public Map<String, String> queryNewsDetail(String user_id);
	public boolean updateUser(User user) ;
		
	
	
}
