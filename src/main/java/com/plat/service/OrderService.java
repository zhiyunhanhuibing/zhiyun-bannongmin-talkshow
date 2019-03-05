package com.plat.service;

import com.plat.bean.OrderGoods;
import com.plat.bean.OrderGoodsKey;
import com.plat.bean.OrderReq;
import com.plat.bean.OrderResp;
import com.plat.config.PageBean;

/**
 * 订单相关Service
 * @author Administrator
 *
 */
public interface OrderService {
	/**
	 * 查询订单信息
	 * @param req
	 * @return
	 */
     public PageBean<OrderResp> queryOrder(OrderReq req);
     
     /**
      * 查询订单下的商品信息
      * @param ogk
      * @return
      */
     public PageBean<OrderGoods> queryOrderGoods(OrderGoodsKey ogk);
}
