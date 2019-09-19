package com.wd.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.wd.dao.IOrderDao;
import com.wd.po.Order1;
import com.wd.util.DBUtil;

public class OrderDao implements IOrderDao {

	@Override
	public boolean addOrder(Order1 order) {
		return DBUtil.executeUpdate("insert into order1(username,order_date,sc_id,order_price) values(?,?,?,?)",
				new Object[] {order.getUsername(),order.getOrder_date(),order.getSc_id(),order.getOrder_price()});
	}

	@Override
	public int queryOrderCount(String username) {
		String sql="select count(*) as totalcount from order1";
		List<Object> list = new ArrayList<Object>();
		
		if (username != null && !"".equals(username)) {
			sql += " where good_name like ?";
			list.add("%" + username + "%");
		}
		
		return Integer.valueOf(DBUtil.executeQuery(sql, list.size() > 0 ? list.toArray() : null).get(0).get("totalcount"));
	}

	@Override
	public List<Map<String, String>> queryOrderByPage(int cpage, int pagesize, String username) {
String sql="select * from order1";
		
		List<Object> list =new ArrayList<Object>();
		if(username !=null&&!"".equals(username)){
			sql +=" where good_name like ?";
			list.add("%" + username + "%");
		}
		
		sql +=" limit ?,?";
		list.add((cpage-1)*pagesize);
		list.add(pagesize);
		return DBUtil.executeQuery(sql, list.toArray());
	}

	@Override
	public boolean deletorder(Order1 order) {
		// TODO Auto-generated method stub
		return false;
	}

}
