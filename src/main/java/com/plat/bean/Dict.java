package com.plat.bean;

import java.io.Serializable;

import lombok.Data;

/**
 * 字典管理
 * @author CR
 *
 */
@Data
public class Dict implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 主键ID
	 */
	private String id;
	/**
	 * 类型编码
	 */
	private String type;
	/**
	 * 字典值编码
	 */
	private String code;
	/**
	 * 字典数值
	 */
	private String name; 
	/**
	 * sql语句
	 */
	private String sql; 
	/**
	 * 数据源
	 */
	private String database; 
}
