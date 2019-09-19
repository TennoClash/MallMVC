package com.wd.dao;

import java.util.List;
import java.util.Map;

import com.wd.po.Goods;

public interface IGoodsDao {
	public boolean addGoods(Goods goods) ;
	
	public int queryGoodsCount(String good_name);
	
	public List<Map<String, String>> queryGoodsByPage(int cpage, int pagesize, String good_name);
	
	public Map<String, String> queryGoodsDetail(String good_id);
}
