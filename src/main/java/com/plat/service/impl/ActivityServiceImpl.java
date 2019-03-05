package com.plat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plat.bean.Activity;
import com.plat.bean.ActivityGoods;
import com.plat.bean.ActivityPriKey;
import com.plat.bean.ActivityResp;
import com.plat.bean.OperationDbMessage;
import com.plat.constant.ActivityErrors;
import com.plat.dao.ActivityDao;
import com.plat.exception.PlatException;
import com.plat.service.ActivityService;

/**
 * 设置活动Service实现类
 * @author CR
 *
 */
@Service
public class ActivityServiceImpl implements ActivityService{
    @Autowired
    private ActivityDao dao;
	
	@Override
	public OperationDbMessage addActivity(Activity ac) {
		OperationDbMessage odm = new OperationDbMessage();
		try {
			int addCount = dao.addActivity(ac);
			if(addCount == 0) {
				throw new PlatException(ActivityErrors.ADD_ACTIVITY_ERROR, "保存活动信息");
			}
			odm.setStatusCode(200);
			odm.setStatusMessage("保存成功！");
			return odm;
		} catch (Exception e) {
			throw new PlatException(ActivityErrors.ADD_ACTIVITY_ERROR, "保存活动信息", e);
		}
	}

	@Override
	public OperationDbMessage modifyActivity(Activity ac) {
		OperationDbMessage odm = new OperationDbMessage();
		try {
			int modifyCount = dao.modifyActivity(ac);
			if(modifyCount == 0) {
				throw new PlatException(ActivityErrors.MODIFY_ACTIVITY_ERROR, "修改活动信息");
			}
			odm.setStatusCode(200);
			odm.setStatusMessage("修改成功！");
			return odm;
		} catch (Exception e) {
			throw new PlatException(ActivityErrors.MODIFY_ACTIVITY_ERROR, "修改活动信息", e);
		}
	}

	@Override
	public ActivityResp queryActivity(ActivityPriKey acKey) {
		return dao.queryActivity(acKey);
	}

	@Override
	@Transactional
	public OperationDbMessage addActivityToGoogs(ActivityGoods ag) {
		OperationDbMessage odm = new OperationDbMessage();
		List<String> liGoodsId = ag.getGoodsIds();
		try {
			for (String goodsId : liGoodsId) {
				int updateIndex = dao.ActivityToGoods(ag.getActivityType(), goodsId);
				if(updateIndex == 0) {
					throw new PlatException(ActivityErrors.UPDATE_GOODS_GOODS_TO_ACTIVITY_ERROR, "关联活动到商品");
				}
			}	
			odm.setStatusCode(200);
			odm.setStatusMessage("关联活动到商品成功！");
		} catch (Exception e) {
			throw new PlatException(ActivityErrors.ADD_GOODS_TO_ACTIVITY_ERROR, "关联活动到商品", e);
		}
		return odm;
	}

}
