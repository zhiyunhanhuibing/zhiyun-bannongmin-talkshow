package com.plat.constant;

import com.plat.exception.ErrorEnumInterface;
import com.plat.exception.ErrorInfo;

import lombok.Getter;

/**
 * 辅助类异常定义
 * @author chenrong
 *
 */
public enum UtilErrors implements ErrorEnumInterface{
	/**
	 * "200000","md5加密过程出错"
	 */
	MD5_ERROR(new ErrorInfo("200000","md5加密过程出错"));
	
	@Getter
	private ErrorInfo errorInfo;
	UtilErrors(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}
}
