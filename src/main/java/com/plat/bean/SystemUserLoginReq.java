package com.plat.bean;

import lombok.Data;

@Data
public class SystemUserLoginReq {

	//系统用户ID
	private String id;
	
	//用户名
	private String userName;
	
	//密码
	private String password;
	
}
