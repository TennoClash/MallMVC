package com.wd.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.wd.dao.IShoppingCratDao;
import com.wd.po.Order1;
import com.wd.po.Shoppingcart;
import com.wd.util.DBUtil;

public class ShoppingCartDao implements IShoppingCratDao {

	@Override
	public boolean addcart(Shoppingcart shoppingcart) {
		return DBUtil.executeUpdate("insert into shoppingcart(username,sc_count,good_name,good_pic,good_price) values(?,?,?,?,?)",
				new Object[] {shoppingcart.getUsername(),shoppingcart.getSc_count(),shoppingcart.getGood_name(),shoppingcart.getGood_pic(),shoppingcart.getGood_price()});
	}

	@Override
	public List<Map<String, String>> queryGoodsByPage(int cpage, int pagesize,String username ,String good_name) {
String sql="select * from shoppingcart";
		
		List<Object> list =new ArrayList<Object>();
		sql +=" where username=?";
		list.add(username);
		
		if(good_name !=null&&!"".equals(good_name)){
			sql +=" and good_name like ?";
			list.add("%" + good_name + "%");
		}
		
		sql +=" limit ?,?";
		list.add((cpage-1)*pagesize);
		list.add(pagesize);
		return DBUtil.executeQuery(sql, list.toArray());
	}

	@Override
	public int queryGoodsCount(String good_name) {
		String sql="select count(*) as totalcount from shoppingcart";
		List<Object> list = new ArrayList<Object>();
		
		if (good_name != null && !"".equals(good_name)) {
			sql += " where good_name like ?";
			list.add("%" + good_name + "%");
		}
		
		return Integer.valueOf(DBUtil.executeQuery(sql, list.size() > 0 ? list.toArray() : null).get(0).get("totalcount"));
	}

	@Override
	public Map<String, String> queryGoodsDetail(String username) {
		return DBUtil.executeQuery( "select * from shoppingcart where username=?", new Object[] { username}).get(0);
	}

	@Override
	public boolean deleteCart(Shoppingcart shoppingcart) {
		return DBUtil.executeUpdate("delete from shoppingcart where sc_id=?", new Object[] { shoppingcart.getSc_id() });
	}

	@Override
	public boolean deleteCart2(Shoppingcart shoppingcart) {
		return DBUtil.executeUpdate("delete from shoppingcart where username=?", new Object[] { shoppingcart.getUsername()});
	}

	

}
