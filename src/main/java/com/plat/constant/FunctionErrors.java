package com.plat.constant;

import com.plat.exception.ErrorEnumInterface;
import com.plat.exception.ErrorInfo;

import lombok.Getter;

/**
 * 字典异常信息
 * @author Administrator
 *
 */
public enum FunctionErrors  implements ErrorEnumInterface{
	/**
	 * "0700001","添加页面功能出错！"
	 */
    ADD_FUNCTION_ERROR(new ErrorInfo("0700001","添加页面功能出错！")),
	/**
	 * "0700002","删除页面功能出错！"
	 */
    DEL_FUNCTION_ERROR(new ErrorInfo("0700002","删除页面功能出错！")),
	/**
	 * "0700003","修改页面功能出错！"
	 */
    UPDATE_FUNCTION_ERROR(new ErrorInfo("0700003","修改页面功能出错！")),
    /**
	 * "0700004","查询页面功能出错！"
	 */
    QUERY_FUNCTION_ERROR(new ErrorInfo("0700004","查询页面功能出错！")),
    /**
	 * "0700005","关联角色-功能功能出错！"
	 */
    REL_ROLE_FUNCTION_ERROR(new ErrorInfo("0700005","关联角色-功能功能出错！"));
	
	@Getter
	private ErrorInfo errorInfo;
	FunctionErrors(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}
}
