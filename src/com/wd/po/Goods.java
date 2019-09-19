package com.wd.po;

public class Goods {
	private String good_id;
	private String good_name;
	private String good_type;
	private String good_price;
	private String good_discount;
	private String good_desc;
	private String supplier;
	private String qty;
	private String ispreferred;
	private String good_pic;
	public String getGood_id() {
		return good_id;
	}
	public void setGood_id(String good_id) {
		this.good_id = good_id;
	}
	public String getGood_name() {
		return good_name;
	}
	public void setGood_name(String good_name) {
		this.good_name = good_name;
	}
	public String getGood_type() {
		return good_type;
	}
	public void setGood_type(String good_type) {
		this.good_type = good_type;
	}
	public String getGood_price() {
		return good_price;
	}
	public void setGood_price(String good_price) {
		this.good_price = good_price;
	}
	public String getGood_discount() {
		return good_discount;
	}
	public void setGood_discount(String good_discount) {
		this.good_discount = good_discount;
	}
	public String getGood_desc() {
		return good_desc;
	}
	public void setGood_desc(String good_desc) {
		this.good_desc = good_desc;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getIspreferred() {
		return ispreferred;
	}
	public void setIspreferred(String ispreferred) {
		this.ispreferred = ispreferred;
	}
	public String getGood_pic() {
		return good_pic;
	}
	public void setGood_pic(String good_pic) {
		this.good_pic = good_pic;
	}
	public Goods(String good_id, String good_name, String good_type, String good_price, String good_discount,
			String good_desc, String supplier, String qty, String ispreferred, String good_pic) {
		super();
		this.good_id = good_id;
		this.good_name = good_name;
		this.good_type = good_type;
		this.good_price = good_price;
		this.good_discount = good_discount;
		this.good_desc = good_desc;
		this.supplier = supplier;
		this.qty = qty;
		this.ispreferred = ispreferred;
		this.good_pic = good_pic;
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
