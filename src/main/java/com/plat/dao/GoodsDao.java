package com.plat.dao;


import java.util.List;

import com.plat.bean.Goods;
import com.plat.bean.GoodsKey;
import com.plat.bean.GoodsReq;
import com.plat.bean.GoodsReqBean;

public interface GoodsDao {
	public int goodsSave(GoodsReqBean goods) ;

//	public List<Goods> goodsSelectAll();

	public int goodsDelete(GoodsKey goods);

	public List<Goods> goodsSelectByType(GoodsReq goods);

	public int goodsUpdateOne(GoodsReqBean goods);
}
