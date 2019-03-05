package com.plat.dao;

import java.util.List;

import com.plat.bean.OrderGoods;
import com.plat.bean.OrderGoodsKey;
import com.plat.bean.OrderReq;
import com.plat.bean.OrderResp;

/**
 * 订单相关dao
 * @author CR
 *
 */
public interface OrderDao {
	/**
	 * 查询订单信息
	 * @param req
	 * @return
	 */
	public List<OrderResp> queryOrder(OrderReq req);
	
	/**
	 * 查看订单商品
	 * @param ogk
	 * @return
	 */
	public List<OrderGoods> queryOrderGoods(OrderGoodsKey ogk);
}
