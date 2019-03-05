package com.plat.exception;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * 定义错误信息实体
 * @author chenrong
 *
 */
@Data
@Builder
@ToString
public class ErrorInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 错误编码
	 */
	private String code;
	/**
	 * 错误信息
	 */
	private String message;

	/**
	 * 错误信息
	 * @param code     错误编码
	 * @param message  错误信息描述
	 */
	public ErrorInfo(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
