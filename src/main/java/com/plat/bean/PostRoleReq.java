package com.plat.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper= false)
public class PostRoleReq extends PageReq implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 角色名称
	private String roleName;

	// 备注
	private String mark;

	// 功能标识
	private String code;
}
