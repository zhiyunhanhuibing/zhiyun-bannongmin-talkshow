package com.plat.exception;

import java.io.Serializable;

import lombok.Data;
/**
 * 定义异常类 异常体实体
 * @author chenrong
 *
 */
@Data
public class BaseExceptionBody implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String message;
	private String bussinessId;
	private String codeEn;
	private String addtionalMessage;
	private String exceptionType;

	public BaseExceptionBody() {
		
	}
	
	public BaseExceptionBody(BaseException exception) {
		this.code = exception.getCode();
		this.message = exception.getMessage();
		this.bussinessId = exception.getBussinessId();
		this.codeEn = exception.getCodeEn();
		this.addtionalMessage = exception.getAddtionalMessage();
		this.exceptionType = exception.getClass().getName();
	}
}
