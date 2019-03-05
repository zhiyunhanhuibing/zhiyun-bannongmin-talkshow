package com.plat.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 订单商品表实体
 * @author Administrator
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper= false)
public class OrderGoods extends OrderGoodsKey{
	private static final long serialVersionUID = 1L;
	
	private Integer goodsNumber; 
	private Double goodsPrice; 
	private Double goodsTotal; 
	private String goodsName;
	private String createTime; 
	private String updateTime; 
}
