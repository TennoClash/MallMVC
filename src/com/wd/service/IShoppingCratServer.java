package com.wd.service;

import java.util.List;
import java.util.Map;

import com.wd.po.Shoppingcart;

public interface IShoppingCratServer {
	public boolean addcart(Shoppingcart shoppingcart);
	
	public List<Map<String, String>> queryGoodsByPage(int cpage, int pagesize,String username ,String good_name);
	
	public int queryGoodsCount(String good_name);
	
	public Map<String, String> queryGoodsDetail(String username) ;
	
	public boolean deleteCart(Shoppingcart shoppingcart);
	
	public boolean deleteCart2(Shoppingcart shoppingcart);
}
