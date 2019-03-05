package com.plat.constant;

import com.plat.exception.ErrorEnumInterface;
import com.plat.exception.ErrorInfo;

import lombok.Getter;

/**
 * 字典异常信息
 * @author Administrator
 *
 */
public enum DictErrors  implements ErrorEnumInterface{
	/**
	 * "0100001","添加字典信息出错！"
	 */
    DICT_ADD_ERROR(new ErrorInfo("0100001","添加字典信息出错！")),
	/**
	 * "0100002","删除字典信息出错！"
	 */
    DICT_DEL_ERROR(new ErrorInfo("0100002","删除字典信息出错！")),
	/**
	 * "0100003","修改字典信息出错！"
	 */
    DICT_UPDATE_ERROR(new ErrorInfo("0100003","修改字典信息出错！")),
    /**
	 * "0100004","未找到对应字典类型！"
	 */
    NOTHING_DICT_TYPE(new ErrorInfo("0100004","未找到对应字典类型！")),
    /**
	 * "0100005","数据库冗余数据，请检查数据库！"
	 */
    DB_DATA_ERROR(new ErrorInfo("0100005","数据库冗余数据，请检查数据库！"));
	
	@Getter
	private ErrorInfo errorInfo;
	DictErrors(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}
}
