package com.plat.constant;

import com.plat.exception.ErrorEnumInterface;
import com.plat.exception.ErrorInfo;

import lombok.Getter;

public enum CommonErrors implements ErrorEnumInterface{
	COMMON_ERROR(new ErrorInfo("100000","通用异常")),
	REQ_PARAM_ERROR(new ErrorInfo("100001","参数异常："));
	@Getter
	private ErrorInfo errorInfo;
	CommonErrors(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}
}
