package com.plat.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.plat.bean.OrderGoods;
import com.plat.bean.OrderGoodsKey;
import com.plat.bean.OrderReq;
import com.plat.bean.OrderResp;
import com.plat.config.PageBean;
import com.plat.dao.OrderDao;
import com.plat.service.OrderService;

/**
 * 订单相关service实现类
 * @author CR
 *
 */
@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao dao;

	/**
	 * 查询订单信息
	 */
	@Override
	public PageBean<OrderResp> queryOrder(OrderReq req) {
		Integer pageIndex = req.getPageIndex();
		Integer pageRows = req.getPageRows();
		// 默认第一页，每页15条
		if(Objects.isNull(pageIndex) || pageIndex<1) {
			pageIndex = 1;
		}
		if(Objects.isNull(pageRows) || pageRows<1) {
			pageRows = 15;
		}
		PageHelper.startPage(pageIndex, pageRows);
		List<OrderResp> liItems = dao.queryOrder(req);
		int countIndex = liItems.size();
		return new PageBean<>(pageIndex, pageRows, countIndex,liItems);
	}

	/**
	 * 查询订单下商品信息
	 */
	@Override
	public PageBean<OrderGoods> queryOrderGoods(OrderGoodsKey ogk) {
		Integer pageIndex = ogk.getPageIndex();
		Integer pageRows = ogk.getPageRows();
		// 默认第一页，每页15条
		if(Objects.isNull(pageIndex) || pageIndex<1) {
			pageIndex = 1;
		}
		if(Objects.isNull(pageRows) || pageRows<1) {
			pageRows = 15;
		}
		PageHelper.startPage(pageIndex, pageRows);
		List<OrderGoods> liItems = dao.queryOrderGoods(ogk);
		int countIndex = liItems.size();
		return new PageBean<>(pageIndex, pageRows, countIndex, liItems);
	}

}
