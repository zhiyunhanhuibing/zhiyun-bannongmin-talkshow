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
public class SystemUserReq extends PageReq implements Serializable{
	private static final long serialVersionUID = 1L;

	// 系统用户ID
	private String id;

	// 用户名
	private String userName;

	// 密码
	private String password;

	// 联系方式
	private String tel;

	// 微信号
	private String weixin;

	// 地址
	private String address;

	// 有效期至
	private String limitTime;

	// 创建人
	private String createBy;

}
