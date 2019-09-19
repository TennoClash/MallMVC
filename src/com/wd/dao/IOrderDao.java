package com.wd.dao;

import java.util.List;
import java.util.Map;

import com.wd.po.Order1;

public interface IOrderDao {
	public boolean addOrder(Order1 order) ;
	
public int queryOrderCount(String username);
	
	public List<Map<String, String>> queryOrderByPage(int cpage, int pagesize, String username);
	
	public boolean deletorder(Order1 order);
}
