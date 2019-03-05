package com.plat.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.plat.exception.BaseException;
import com.plat.exception.BaseExceptionBody;
import com.plat.exception.PlatException;

/**
 * 统一异常处理拦截器
 * @author chenrong
 *
 */
@ControllerAdvice
public class ControllerExceptionHandle {
	
	@ExceptionHandler(value= BaseException.class)
	public ResponseEntity<BaseExceptionBody> handlBaseException(BaseException exception, HttpServletRequest request){
		return new ResponseEntity<>(new BaseExceptionBody(exception), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(value= PlatException.class)
	public ResponseEntity<BaseExceptionBody> handlPlatException(PlatException exception, HttpServletRequest request){
		return new ResponseEntity<>(new BaseExceptionBody(exception), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
