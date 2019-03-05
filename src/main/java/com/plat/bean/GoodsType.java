package com.plat.bean;

import java.io.Serializable;

import lombok.Data;

/**
 * 商品类型实体
 * @author CR
 *
 */
@Data
public class GoodsType implements Serializable{
	private static final long serialVersionUID = 4156040841654214126L;
	/**
	 * 编号
	 */
	private String id;
	/**
	 * 类型编码
	 */
	private String type;
	/**
	 * 类型名称
	 */
	private String typeName;
	/**
	 * 父类型编号
	 */
	private String parentId;
	/**
	 * 类型描述
	 */
	private String describe;
	/**
	 * 文件名称
	 */
	private String fileName;
	/**
	 * 文件原名
	 */
	private String fileOriginalName;
	/**
	 * 文件链接地址
	 */
	private String filePath;
}
