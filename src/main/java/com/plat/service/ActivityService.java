package com.plat.service;

import com.plat.bean.Activity;
import com.plat.bean.ActivityGoods;
import com.plat.bean.ActivityPriKey;
import com.plat.bean.ActivityResp;
import com.plat.bean.OperationDbMessage;

/**
 * 设置活动信息Service
 * @author CR
 *
 */
public interface ActivityService {
	/**
	 * 添加活动信息
	 * @param ac
	 * @return
	 */
	public OperationDbMessage addActivity(Activity ac);
	/**
	 * 修改活动信息
	 * @param acKey
	 * @return
	 */
	public OperationDbMessage modifyActivity(Activity ac);
	/**
	 * 查询活动信息
	 * @param acKey
	 * @return
	 */
	public ActivityResp queryActivity(ActivityPriKey acKey);
	/**
	 * 
	 * 关联活动到商品
	 * @param ag
	 * @return
	 */
	public OperationDbMessage addActivityToGoogs(ActivityGoods ag);
}
