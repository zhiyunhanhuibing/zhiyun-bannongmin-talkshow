package com.plat.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 收货地址入参实体
 * @author Administrator
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper= false)
public class CollectGoodsAddressReq extends PageReq implements Serializable{
	private static final long serialVersionUID = -3616862333338491487L;
	/**
	 * 主键编号
	 */
	private String id;
	/**
	 * 用户微信号（确定登录用户）
	 */
	private String collectUserWeixin;
	/**
	 * 用户手机号（确定登录用户）
	 */
	private String collectUserTel;
	/**
	 * 姓名
	 */
	private String nameEn;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 电话
	 */
	private String tel;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 详细地址
	 */
	private String detailedAddress;
}
