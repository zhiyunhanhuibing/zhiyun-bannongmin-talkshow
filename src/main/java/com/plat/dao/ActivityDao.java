package com.plat.dao;

import org.apache.ibatis.annotations.Param;

import com.plat.bean.Activity;
import com.plat.bean.ActivityPriKey;
import com.plat.bean.ActivityResp;

/**
 * 设置活动信息DAO
 * @author CR
 *
 */
public interface ActivityDao {
	/**
	 * 添加活动信息
	 * @param ac
	 * @return
	 */
	public int addActivity(Activity ac);
	/**
	 * 修改活动信息
	 * @param acKey
	 * @return
	 */
	public int modifyActivity(Activity ac);
	/**
	 * 查询活动信息
	 * @param acKey
	 * @return
	 */
	public ActivityResp queryActivity(ActivityPriKey acKey);
	/**
	 * 关联活动到商品
	 * @param ag
	 * @return
	 */
	public int ActivityToGoods(@Param("activityType") String activityType, @Param("goodsId") String goodsId);
}
