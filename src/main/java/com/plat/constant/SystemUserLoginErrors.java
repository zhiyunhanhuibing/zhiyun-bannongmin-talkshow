package com.plat.constant;

import com.plat.exception.ErrorEnumInterface;
import com.plat.exception.ErrorInfo;

import lombok.Getter;

/**
 * 
 * @Description 系统用户操作错误信息
 * @author yuanhuimeng Date:2018-12-04 14:33:16
 */
public enum SystemUserLoginErrors implements ErrorEnumInterface {
	/**
	 * "1100001","系统用户为空！"
	 */
	SYSUSER_ISNULL_ERROR(new ErrorInfo("1100001", "用户为空！")),
	/**
	 * "1100002","系统用户名为空！"
	 */
	SYSUSER_USERNAME_ISNULL_ERROR(new ErrorInfo("1100002", "用户名为空！")),
	/**
	 * "1100003","系统用户密码为空！"
	 */
	SYSUSER_PASSWORD_ISNULL_ERROR(new ErrorInfo("1100003", "用户密码为空！")),
	/**
	 * "1100004","系统用户登录失败！"
	 */
	SYSUSER_LOGIN_FAIL_ERROR(new ErrorInfo("1100004", "用户登录失败！"));

	@Getter
	private ErrorInfo errorInfo;

	SystemUserLoginErrors(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}
}
