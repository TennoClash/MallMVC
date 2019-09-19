package com.wd.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.wd.dao.IUserDao;
import com.wd.po.User;
import com.wd.util.DBUtil;

public class UserDao implements IUserDao {


	@Override
	public boolean addUser(User user) {
		return DBUtil.executeUpdate(
				"insert into userinfo(username,password,email,gender,realname,phone,user_type) values(?,?,?,?,?,?,?)",
				new Object[] { user.getUsername(), user.getPassword(), user.getEmail(),user.getGender(),user.getRealname(),user.getPhone(),user.getUser_type()});
	}

	@Override
	public User getUserByNameAndPwd(String username, String password) {
		List<Map<String, String>> resultlist = DBUtil.executeQuery(
				"select * from userinfo where username=? and password=?", new Object[] { username, password });
		if (resultlist.size() > 0) {
			Map<String, String> m = resultlist.get(0);
			User user = new User(m.get("user_id"), m.get("username"), m.get("password"), m.get("email"), m.get("gender"),
					m.get("realname"), m.get("phone"), m.get("user_type"));
			return user;
		} else {
			return null;
		}
	}

	@Override
	public List<Map<String, String>> queryUserByPage(int cpage, int pagesize, String username) {
String sql="select user_id,username,email,gender,phone,user_type from userinfo";
		
		List<Object> list =new ArrayList<Object>();
		if(username !=null&&!"".equals(username)){
			sql +=" where username like ?";
			list.add("%" + username + "%");
		}
		
		sql +=" limit ?,?";
		list.add((cpage-1)*pagesize);
		list.add(pagesize);
		return DBUtil.executeQuery(sql, list.toArray());
	}

	@Override
	public int queryUserCount(String username) {
		String sql="select count(*) as totalcount from userinfo";
		List<Object> list = new ArrayList<Object>();
		
		if (username != null && !"".equals(username)) {
			sql += " where username like ?";
			list.add("%" + username + "%");
		}
		
		return Integer.valueOf(DBUtil.executeQuery(sql, list.size() > 0 ? list.toArray() : null).get(0).get("totalcount"));
	}

	@Override
	public boolean deleteUser(User user) {
		return DBUtil.executeUpdate("delete from userinfo where user_id=?", new Object[] { user.getUser_id() });
	}

	@Override
	public boolean updateUserinfo(User user) {
		return DBUtil.executeUpdate("update userinfo set email=?,gender=?,phone=?,user_type=? where user_id=?",
				new Object[] {user.getEmail(),user.getGender(),user.getPhone(),user.getUser_type(),user.getUser_id()});
	}

	@Override
	public Map<String, String> queryNewsDetail(String user_id) {
		return DBUtil.executeQuery("select * from userinfo where user_id=?", new Object[] { user_id}).get(0);
	}

	@Override
	public boolean updateUser(User user) {
		return DBUtil.executeUpdate("update userinfo set password=? where user_id=?",
				new Object[] { user.getPassword(),user.getUser_id()});
	}

	

}
