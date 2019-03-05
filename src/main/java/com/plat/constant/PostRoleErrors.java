package com.plat.constant;

import com.plat.exception.ErrorEnumInterface;
import com.plat.exception.ErrorInfo;

import lombok.Getter;

/**
 * 
 * @Description 角色信息操作错误提示
 * @author yuanhuimeng
 * Date:2019-01-07 09:32:37
 */
public enum PostRoleErrors  implements ErrorEnumInterface{
	/**
	 * "0000001","添加用户角色出错！"
	 */
    POSTROLE_ADD_ERROR(new ErrorInfo("1000001","添加用户角色出错！")),
	/**
	 * "0000002","删除用户角色出错！"
	 */
    POSTROLE_DEL_ERROR(new ErrorInfo("1000002","删除用户角色出错！")),
	/**
	 * "0000003","修改用户角色出错！"
	 */
    POSTROLE_UPDATE_ERROR(new ErrorInfo("1000003","修改用户角色出错！"));
	@Getter
	private ErrorInfo errorInfo;
	PostRoleErrors(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}
}
