package com.plat.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * 商品查询入参
 * @author CR
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper= false)
public class GoodsReq extends PageReq implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 商品类型
	 */
	private String type;
	/**
	 * 商品名称
	 */
	private String goodsName;
	
	/**
	 * 原价 范围
	 */
	private Double originalStartPrice;
	private Double originalEndPrice;
	/**
	 * 促销价 范围
	 */
	private Double promotionStartPrice;
	private Double promotionEndPrice;
	/**
	 * 会员价 范围
	 */
	private Double vipStartPrice;
	private Double vipEndPrice;
	/**
	 * 保质期 时间范围  入参 年会日
	 */
	private String qualityStartDate; 
	private String qualityEndDate;
	/**
	 * 单位
	 */
	private String unit; 
	/**
	 * 品牌
	 */
	private String brand; 

}
