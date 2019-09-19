package com.wd.service.impl;

import java.util.List;
import java.util.Map;

import com.wd.dao.IOrderDao;
import com.wd.dao.impl.OrderDao;
import com.wd.po.Order1;
import com.wd.service.IOrderService;

public class OrderService implements IOrderService {
IOrderDao orderdao;


	public OrderService() {
	super();
	orderdao = new OrderDao();
}


	@Override
	public boolean addOrder(Order1 order) {
		return orderdao.addOrder(order);
	}


	@Override
	public int queryOrderCount(String username) {
		return orderdao.queryOrderCount(username);
	}


	@Override
	public List<Map<String, String>> queryOrderByPage(int cpage, int pagesize, String username) {
		return orderdao.queryOrderByPage(cpage, pagesize, username);
	}

}
