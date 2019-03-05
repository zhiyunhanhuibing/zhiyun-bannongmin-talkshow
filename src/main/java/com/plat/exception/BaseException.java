package com.plat.exception;

import com.google.common.base.CaseFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 自定义异常基类
 * @author chenrong
 *
 */
@Getter
@ToString
public class BaseException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private String code;
    private String codeEn;
    private String bussinessId;
    @Setter
    private String addtionalMessage;
    
    public <T extends Enum<T> & ErrorEnumInterface> BaseException(T errorEnum){
    	this(errorEnum, "");
    }
    
    public <T extends Enum<T> & ErrorEnumInterface> BaseException(T errorEnum, String businessId){
    	this(errorEnum, businessId, null);
    }
    
    public <T extends Enum<T> & ErrorEnumInterface> BaseException(T errorEnum, String businessId, Throwable cause){
    	super(errorEnum.getErrorInfo().getMessage(), cause);
    	this.code = errorEnum.getErrorInfo().getCode();
    	this.bussinessId = businessId;
    	this.codeEn = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, errorEnum.name());
    }

	public BaseException(String message, String errorCode, String codeEn, String bussinessId, Throwable cause) {
		super(message, cause);
		this.code = errorCode;
		this.bussinessId = bussinessId;
		this.codeEn = code;
	}
}
