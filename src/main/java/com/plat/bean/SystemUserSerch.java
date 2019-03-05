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
public class SystemUserSerch extends PageReq implements Serializable{
	private static final long serialVersionUID = 1L;

	// 用户名
	private String userName;

	// 联系方式
	private String tel;

	// 微信号
	private String weixin;

	// 地址
	private String address;

	// 有效期开始时间
	private String startLimitTime;
	
	//有效期结束时间
	private String endLimitTime;

}
