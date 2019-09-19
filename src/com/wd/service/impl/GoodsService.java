package com.wd.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.io.input.ReversedLinesFileReader;

import com.wd.dao.IGoodsDao;
import com.wd.dao.impl.GoodsDao;
import com.wd.po.Goods;
import com.wd.service.IGoodsService;

public class GoodsService implements IGoodsService {
IGoodsDao goodsdao;

	public GoodsService() {
	super();
	goodsdao=new GoodsDao();
	}

	@Override
	public boolean addGoods(Goods goods) {
		return goodsdao.addGoods(goods);
	}

	@Override
	public int queryGoodsCount(String good_name) {
		return goodsdao.queryGoodsCount(good_name);
	}

	@Override
	public List<Map<String, String>> queryGoodsByPage(int cpage, int pagesize, String good_name) {
		// TODO Auto-generated method stub
		return goodsdao.queryGoodsByPage(cpage, pagesize, good_name);
	}

	@Override
	public Map<String, String> queryGoodsDetail(String good_id) {
		return goodsdao.queryGoodsDetail(good_id);
		
	}

}
