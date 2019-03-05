package com.plat.bean;

import java.io.Serializable;

import lombok.Data;

/**
 * 查询字典数据返回结果集Bean
 * @author CR
 *
 */
@Data
public class DictData implements Serializable{
	private static final long serialVersionUID = 1L;
	private String code;
    private String name;
}
