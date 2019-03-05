package com.plat.constant;

import com.plat.exception.ErrorEnumInterface;
import com.plat.exception.ErrorInfo;

import lombok.Getter;

/**
 * 字典异常信息
 * @author Administrator
 *
 */
public enum ActivityErrors  implements ErrorEnumInterface{
    /**
	 * "0600001","保存活动信息出错！"
	 */
    ADD_ACTIVITY_ERROR(new ErrorInfo("0600001","保存活动信息出错！")), 
    /**
	 * "0600002","修改活动信息出错！"
	 */
    MODIFY_ACTIVITY_ERROR(new ErrorInfo("0600002","修改活动信息出错！")),
    /**
	 * "0600003","查询活动信息出错！"
	 */
    QUERY_ACTIVITY_ERROR(new ErrorInfo("0600003","查询活动信息出错！")),
	/**
     * "0600004","关联商品到活动出错！"
     */
    ADD_GOODS_TO_ACTIVITY_ERROR(new ErrorInfo("0600004","关联商品到活动出错！")),
    /**
     * "0600005","关联商品到活动,修改商品表出错！"
     */
    UPDATE_GOODS_GOODS_TO_ACTIVITY_ERROR(new ErrorInfo("0600005","关联商品到活动,修改商品表出错！"));
	
	@Getter
	private ErrorInfo errorInfo;
	ActivityErrors(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}
}
