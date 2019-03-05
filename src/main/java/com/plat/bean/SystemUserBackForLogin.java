package com.plat.bean;

import java.util.List;

import lombok.Data;

@Data
public class SystemUserBackForLogin extends OperationDbMessage {

	private static final long serialVersionUID = 1L;

	private String id;

	// 用户名
	private String userName;

	// 联系方式
	private String tel;

	// 微信号
	private String weixin;

	// 地址
	private String address;

	// 角色名称
	private List<String> roleNames;

	// 功能树
	private List<FunctionTree> functionTree;

}
