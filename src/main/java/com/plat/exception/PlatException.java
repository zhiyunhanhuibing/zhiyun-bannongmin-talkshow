package com.plat.exception;

/**
 * 平台异常处理类
 * @author Administrator
 *
 */
public class PlatException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public <T extends Enum<T> & ErrorEnumInterface> PlatException(T errorEnum){
    	this(errorEnum, "");
    }
    
    public <T extends Enum<T> & ErrorEnumInterface> PlatException(T errorEnum, String businessId){
    	this(errorEnum, businessId, null);
    }
    
    public <T extends Enum<T> & ErrorEnumInterface> PlatException(T errorEnum, String businessId, Throwable cause){
    	super(errorEnum, businessId, cause);
    }

	public PlatException(String message, String errorCode, String codeEn, String bussinessId, Throwable cause) {
		super(message, errorCode, codeEn, bussinessId, cause);
	}

}
