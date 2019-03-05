package com.plat.bean;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class FunctionTree implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	/**
	 * 功能连接
	 */
    private String url; 
    /**
     * 功能标识
     */
    private String code; 
    /**
     * 功能名称
     */
    private String name; 
    /**
     * 顺序
     */
    private int order; 
    /**
     * 图标
     */
    private String icon; 
    /**
     * 父标识
     */
    private int parentId; 
    
    private List<?> children;
}
