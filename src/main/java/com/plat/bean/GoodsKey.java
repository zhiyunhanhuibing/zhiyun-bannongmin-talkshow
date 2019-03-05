package com.plat.bean;

import java.io.Serializable;

import lombok.Data;

/**
 * 商品主键
 * @author Administrator
 *
 */
@Data
public class GoodsKey implements Serializable{
	private static final long serialVersionUID = 1L;
	private String type;
	private String goodsId;

}
