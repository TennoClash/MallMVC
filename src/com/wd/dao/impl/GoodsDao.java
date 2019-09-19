package com.wd.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.wd.dao.IGoodsDao;
import com.wd.po.Goods;
import com.wd.util.DBUtil;

public class GoodsDao implements IGoodsDao {

	@Override
	public boolean addGoods(Goods goods) {
		return DBUtil.executeUpdate("insert into goods(good_name,good_type,good_price,good_discount,good_desc,supplier,qty,ispreferred,good_pic) values(?,?,?,?,?,?,?,?,?)",
				new Object[] { goods.getGood_name(),goods.getGood_type(),goods.getGood_price(),goods.getGood_discount(),goods.getGood_desc(),goods.getSupplier(),goods.getQty(),goods.getIspreferred(),goods.getGood_pic() });
	}

	@Override
	public int queryGoodsCount(String good_name) {
		String sql="select count(*) as totalcount from goods";
		List<Object> list = new ArrayList<Object>();
		
		if (good_name != null && !"".equals(good_name)) {
			sql += " where good_name like ?";
			list.add("%" + good_name + "%");
		}
		
		return Integer.valueOf(DBUtil.executeQuery(sql, list.size() > 0 ? list.toArray() : null).get(0).get("totalcount"));
	}

	@Override
	public List<Map<String, String>> queryGoodsByPage(int cpage, int pagesize, String good_name) {
String sql="select good_id,good_name,good_price,good_desc,good_pic from goods";
		
		List<Object> list =new ArrayList<Object>();
		if(good_name !=null&&!"".equals(good_name)){
			sql +=" where good_name like ?";
			list.add("%" + good_name + "%");
		}
		
		sql +=" limit ?,?";
		list.add((cpage-1)*pagesize);
		list.add(pagesize);
		return DBUtil.executeQuery(sql, list.toArray());
	}

	@Override
	public Map<String, String> queryGoodsDetail(String good_id) {
		return DBUtil.executeQuery( "select * from goods where good_id=?", new Object[] { good_id}).get(0);
	}

}
