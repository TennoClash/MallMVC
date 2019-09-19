package com.wd.po;

public class Order1 {

	private String order_id;
	private String order_date;
	private String username;
	private String sc_id;
	private String order_price;
	
	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSc_id() {
		return sc_id;
	}

	public void setSc_id(String sc_id) {
		this.sc_id = sc_id;
	}

	public String getOrder_price() {
		return order_price;
	}

	public void setOrder_price(String order_price) {
		this.order_price = order_price;
	}

	public Order1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order1(String order_id, String order_date, String username, String sc_id, String order_price) {
		super();
		this.order_id = order_id;
		this.order_date = order_date;
		this.username = username;
		this.sc_id = sc_id;
		this.order_price = order_price;
	}
	
	
}
