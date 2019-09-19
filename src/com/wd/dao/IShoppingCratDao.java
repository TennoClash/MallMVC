package com.wd.dao;

import java.util.List;
import java.util.Map;

import com.wd.po.Goods;
import com.wd.po.Order1;
import com.wd.po.Shoppingcart;
import com.wd.po.User;

public interface IShoppingCratDao {
	public boolean addcart(Shoppingcart shoppingcart);
	
	public List<Map<String, String>> queryGoodsByPage(int cpage, int pagesize, String username,String good_name);
	
	public int queryGoodsCount(String good_name);
	
	public Map<String, String> queryGoodsDetail(String username);
	
	public boolean deleteCart(Shoppingcart Shoppingcart);
	
	public boolean deleteCart2(Shoppingcart shoppingcart);
	
}
