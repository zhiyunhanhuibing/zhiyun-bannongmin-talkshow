package com.plat.constant;

import com.plat.exception.ErrorEnumInterface;
import com.plat.exception.ErrorInfo;

import lombok.Getter;

/**
 * 
 * @Description 系统用户操作错误信息
 * @author yuanhuimeng
 * Date:2018-12-04 14:33:16
 */
public enum SystemUserErrors  implements ErrorEnumInterface{
	/**
	 * "0000001","添加系统用户出错！"
	 */
    SYSUSER_ADD_ERROR(new ErrorInfo("1000001","添加系统用户出错！")),
	/**
	 * "0000002","删除系统用户出错！"
	 */
    SYSUSER_DEL_ERROR(new ErrorInfo("1000002","删除系统用户出错！")),
	/**
	 * "0000003","修改系统用户出错！"
	 */
    SYSUSER_UPDATE_ERROR(new ErrorInfo("1000003","修改系统用户出错！"));
	@Getter
	private ErrorInfo errorInfo;
	SystemUserErrors(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}
}
