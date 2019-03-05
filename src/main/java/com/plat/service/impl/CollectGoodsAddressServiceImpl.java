package com.plat.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.plat.bean.CollectGoodsAddressReq;
import com.plat.bean.CollectGoodsAddressResp;
import com.plat.config.PageBean;
import com.plat.dao.CollectGoodsAddressDao;
import com.plat.service.CollectGoodsAddressService;

/**
 * 收货地址管理serviceImpl
 * @author CR
 *
 */
@Service
public class CollectGoodsAddressServiceImpl implements CollectGoodsAddressService{
	@Autowired
	private CollectGoodsAddressDao dao;
	/**
	 * 查询收货地址
	 */
	@Override
	public PageBean<CollectGoodsAddressResp> queryCollectGoodsAddress(CollectGoodsAddressReq req) {
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
		List<CollectGoodsAddressResp> liItems = dao.queryCollectGoodsAddress(req);
		int countIndex = liItems.size();
		return new PageBean<>(pageIndex, pageRows, countIndex, liItems);
	}

}
