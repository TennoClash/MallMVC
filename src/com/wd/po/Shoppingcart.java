package com.wd.po;

public class Shoppingcart {
private String sc_id;
private String good_name;
private String sc_count;
private String username;
private String good_pic;
private String good_price;
public String getSc_id() {
	return sc_id;
}
public void setSc_id(String sc_id) {
	this.sc_id = sc_id;
}
public String getGood_name() {
	return good_name;
}
public void setGood_name(String good_name) {
	this.good_name = good_name;
}
public String getSc_count() {
	return sc_count;
}
public void setSc_count(String sc_count) {
	this.sc_count = sc_count;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getGood_pic() {
	return good_pic;
}
public void setGood_pic(String good_pic) {
	this.good_pic = good_pic;
}
public String getGood_price() {
	return good_price;
}
public void setGood_price(String good_price) {
	this.good_price = good_price;
}
public Shoppingcart(String sc_id, String good_name, String sc_count, String username, String good_pic,
		String good_price) {
	super();
	this.sc_id = sc_id;
	this.good_name = good_name;
	this.sc_count = sc_count;
	this.username = username;
	this.good_pic = good_pic;
	this.good_price = good_price;
}
public Shoppingcart() {
	super();
	// TODO Auto-generated constructor stub
}

}
