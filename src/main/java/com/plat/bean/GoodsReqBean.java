package com.plat.bean;

import java.io.Serializable;
import lombok.Data;

/**
 * 商品管理
 * @author jm
 *
 */
@Data
public class GoodsReqBean implements Serializable{	
	private static final long serialVersionUID = -5704313103184644214L;
	/**
	 * 商品类型编码
	 */
	private String type;
	/**
	 * 商品编码
	 */
	private String goodsId;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 原价
	 */
	private Double originalPrice;
	/**
	 * 促销价
	 */
	private Double promotionPrice;
	/**
	 * 会员价
	 */
	private Double vipPrice;
	/**
	 * 小图片 列表展示
	 */
	private String smallImage;
	/**
	 * 大图片 详情展示
	 */
	private String largeImage;
	/**
	 * 售出数量
	 */
	private Integer sellCount;
	/**
	 * 剩余数量
	 */
	private Integer surplusCount;
	/**
	 * 简述
	 */
	private String sketch;
	/**
	 * 保质期
	 */
	private String qualityDate; 
	/**
	 * 产地
	 */
	private String place; 
	/**
	 * 重量
	 */
	private double goodsWeight;
	/**
	 * 单位
	 */
	private String unit; 
	/**
	 * 品牌
	 */
	private String brand; 
	/**
	 * 长度
	 */
	private Double length; 
	/**
	 * 宽度
	 */
	private Double width;
	/**
	 * 高度
	 */
	private Double height; 
	/**
	 * UPC编码
	 */
	private String upc; 
	/**
	 * 包装清单
	 */
	private String describe;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 最后修改时间
	 */
	private String updateTime;
	/**
	 * 最后修改人
	 */
	private String updateBy;
	/**
	 * 上下架标识
	 */
	private String upperLowerShelf;
}
