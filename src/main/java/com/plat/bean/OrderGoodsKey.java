package com.plat.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 订单商品关联表主键
 * @author Administrator
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class OrderGoodsKey extends PageReq implements Serializable{
	private static final long serialVersionUID = 1L;	
	private String orderId;
	private String goodsId;

}
