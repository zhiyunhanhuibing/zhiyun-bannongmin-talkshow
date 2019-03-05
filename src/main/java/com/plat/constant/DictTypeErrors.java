package com.plat.constant;

import com.plat.exception.ErrorEnumInterface;
import com.plat.exception.ErrorInfo;

import lombok.Getter;

/**
 * 字典类型异常信息
 * @author Administrator
 *
 */
public enum DictTypeErrors  implements ErrorEnumInterface{
	/**
	 * "0100001","添加字典类型信息出错！"
	 */
    DICT_TYPE_ADD_ERROR(new ErrorInfo("0200001","添加字典类型信息出错！")),
	/**
	 * "0100002","修改字典类型信息出错！"
	 */
    DICT_TYPE_DEL_ERROR(new ErrorInfo("0200002","删除字典类型信息出错！")),
	/**
	 * "0100002","修改字典类型信息出错！"
	 */
    DICT_TYPE_UPDATE_ERROR(new ErrorInfo("0200003","删除字典类型信息出错！"));
	
	@Getter
	private ErrorInfo errorInfo;
	DictTypeErrors(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}
}
