package com.wd.service.impl;

import java.util.List;
import java.util.Map;

import com.wd.dao.IShoppingCratDao;
import com.wd.dao.impl.ShoppingCartDao;
import com.wd.po.Shoppingcart;
import com.wd.service.IShoppingCratServer;

public class ShoppingCartServer implements IShoppingCratServer {
	
	
IShoppingCratDao shoppingcartdao;
public ShoppingCartServer() {
	super();
	shoppingcartdao=new ShoppingCartDao();
}
	@Override
	public boolean addcart(Shoppingcart shoppingcart) {
		return shoppingcartdao.addcart(shoppingcart);
	}
	@Override
	public List<Map<String, String>> queryGoodsByPage(int cpage, int pagesize,String username ,String good_name) {
		return shoppingcartdao.queryGoodsByPage(cpage, pagesize, username,good_name);
	}
	@Override
	public int queryGoodsCount(String good_name) {
		return shoppingcartdao.queryGoodsCount(good_name);
	}
	@Override
	public Map<String, String> queryGoodsDetail(String username) {
		return shoppingcartdao.queryGoodsDetail(username);
	}
	@Override
	public boolean deleteCart(Shoppingcart shoppingcart) {
		return shoppingcartdao.deleteCart(shoppingcart);
	}
	@Override
	public boolean deleteCart2(Shoppingcart shoppingcart) {
		return shoppingcartdao.deleteCart2(shoppingcart);
	}

}
