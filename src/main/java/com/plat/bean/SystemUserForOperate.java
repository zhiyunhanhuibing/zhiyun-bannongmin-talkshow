package com.plat.bean;

import java.util.Date;

import lombok.Data;

@Data
public class SystemUserForOperate {

	//系统用户ID
	private String id;
	
	//用户名
	private String userName;
	
	//密码
	private String password;
	
	//联系方式
	private String tel;
	
	//微信号
	private String weixin;
	
	//地址
	private String address;
	
	//有效期至
	private Date limitTime;
	
}
