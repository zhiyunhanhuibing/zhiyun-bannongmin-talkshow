package com.plat.bean;

import lombok.Data;

@Data
public class PostRole {

	private int id;

	// 角色名称
	private String roleName;

	// 备注
	private String mark;

	// 功能标识
	private String code;
}
