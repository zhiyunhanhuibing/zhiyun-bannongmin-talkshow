package com.plat.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 收货地址出参实体
 * @author Administrator
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper=false)
public class CollectGoodsAddressResp extends CollectGoodsAddressReq{
	private static final long serialVersionUID = 1L;
	private Date createTime;
	private String createBy;
	private Date updateTime;
	private String updateBy;

}
