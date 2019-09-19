package com.wd.po;

public class User {
	private String user_id;
	private String username;
	private String password;
	private String email;
	private String gender;
	private String realname;
	private String phone;
	private String user_type;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public User(String user_id,String username, String password, String email, String gender, String realname, String phone,
			String user_type) {
		super();
		this.user_id=user_id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.realname = realname;
		this.phone = phone;
		this.user_type = user_type;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}
