package com.plat.config;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 
 * @Description  session存储
 * @author yuanhuimeng
 * Date:2018-12-06 14:46:47
 */
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
@Data
public class SysUserSesssion implements Serializable{

private static final long serialVersionUID = 9120765714832970813L;
	
	private String id;
	
	private String userName;
	
}
