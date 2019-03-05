package com.plat.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 小程序用户管理表查询请求参数实体
 * @author CR
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper= false)
public class UserReq extends PageReq implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 微信号
	 */
	private String weixin;
	/**
	 * 手机号
	 */
	private String tel;
	/**
	 * vip等级 1vip 0普通用户
	 */
	private String vip;
	/**
	 * 创建时间  时间范围
	 */
	private String startCreateTime;
	private String endCreateTime;
}
