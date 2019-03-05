package com.plat.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 功能实体类
 * 
 * @author CR
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper= false)
public class Function extends FunctionKey{
	private static final long serialVersionUID = 1L;
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
}
