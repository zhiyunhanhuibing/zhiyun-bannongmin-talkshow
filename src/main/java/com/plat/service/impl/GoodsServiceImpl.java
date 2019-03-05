package com.plat.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.plat.bean.Goods;
import com.plat.bean.GoodsKey;
import com.plat.bean.GoodsReq;
import com.plat.bean.GoodsReqBean;
import com.plat.bean.OperationDbMessage;
import com.plat.config.PageBean;
import com.plat.constant.GoodsErrors;
import com.plat.dao.GoodsDao;
import com.plat.exception.PlatException;
import com.plat.service.GoodsService;
/**
 * 
 * @author jm
 *
 */
@Service
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	private GoodsDao goodsDao;
	@Override
	@Transactional
	public OperationDbMessage goodsSave(GoodsReqBean goods) {
		OperationDbMessage message = new OperationDbMessage();
		try {
			int addCount = goodsDao.goodsSave(goods);
			if (addCount == 0) {
				throw new PlatException(GoodsErrors.GOODS_ADD_ERROR, "添加商品");
			}
			message.setStatusCode(200);
			message.setStatusMessage("添加商品成功！");
		} catch (Exception e) {
			e.printStackTrace();
			throw new PlatException(GoodsErrors.GOODS_ADD_ERROR, "添加商品", e);
		}
		return message;
	}
	@Override
	@Transactional
	public OperationDbMessage goodsDelete(GoodsKey goods) {
		try {
			int delCount = goodsDao.goodsDelete(goods);
			if (delCount == 0) {
				throw new PlatException(GoodsErrors.GOODS_DEL_ERROR, "删除商品");
			}
			OperationDbMessage message = new OperationDbMessage();
			message.setStatusCode(200);
			message.setStatusMessage("删除商品成功！");
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PlatException(GoodsErrors.GOODS_DEL_ERROR, "删除商品", e);
		}
	}
	@Override
	public PageBean<Goods> goodsSelectByType(GoodsReq goods) {
		Integer pageIndex = goods.getPageIndex();
		Integer pageRows = goods.getPageRows();
		// 默认第一页，每页15条
		if(Objects.isNull(pageIndex) || pageIndex<1) {
			pageIndex = 1;
		}
		if(Objects.isNull(pageRows) || pageRows<1) {
			pageRows = 15;
		}
		PageHelper.startPage(pageIndex, pageRows);
		List<Goods> liItems = goodsDao.goodsSelectByType(goods);
		int countIndex = liItems.size();
		return new PageBean<>(pageIndex, pageRows, countIndex, liItems);
	}
	@Override
	@Transactional
	public OperationDbMessage goodsUpdateOne(GoodsReqBean goods) {
		try {
			int updateCount = goodsDao.goodsUpdateOne(goods);
			if (updateCount == 0) {
				throw new PlatException(GoodsErrors.GOODS_UPDATE_ERROR, "修改商品");
			}
			OperationDbMessage message = new OperationDbMessage();
			message.setStatusCode(200);
			message.setStatusMessage("修改商品成功！");
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PlatException(GoodsErrors.GOODS_DEL_ERROR, "修改商品", e);
		}
	}

}
