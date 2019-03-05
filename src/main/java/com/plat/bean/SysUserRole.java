package com.plat.bean;

import lombok.Data;

@Data
public class SysUserRole {

	private int id;
	
	//用户ID,以；分割
	private String uid;
	
	//角色ID
	private int rid;
}
