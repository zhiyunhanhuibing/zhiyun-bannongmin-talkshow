package com.plat.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class DictType implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4045129230934926508L;
	/**
	 * 字典类型编码
	 */
	private String type;
	/**
	 * 描述
	 */
	private String describe;
	/**
	 * 是否sql语句标识 1 是  0 否
	 */
	private String isSql;
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
	 * 版本号
	 */
	private String version;

	
}
