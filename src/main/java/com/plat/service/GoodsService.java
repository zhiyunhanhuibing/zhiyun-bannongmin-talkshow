package com.plat.service;

import com.plat.bean.Goods;
import com.plat.bean.GoodsKey;
import com.plat.bean.GoodsReq;
import com.plat.bean.GoodsReqBean;
import com.plat.bean.OperationDbMessage;
import com.plat.config.PageBean;

/**
 * 商品管理相关Service
 * @author JM
 *
 */
public interface GoodsService {
	public OperationDbMessage goodsSave(GoodsReqBean goods) ;
	// public List<Goods> goodsSelectAll();
	public OperationDbMessage goodsDelete(GoodsKey goods);
	public PageBean<Goods> goodsSelectByType(GoodsReq goods);
	public OperationDbMessage goodsUpdateOne(GoodsReqBean goods);
}
