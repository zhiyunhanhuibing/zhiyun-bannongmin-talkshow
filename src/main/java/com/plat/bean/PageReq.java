package com.plat.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 分页公共入参实体
 * @author CR
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageReq implements Serializable{
	private static final long serialVersionUID = -4572232391489445085L;
	/**
	 * 当前页
	 */
	private Integer pageIndex;
	/**
	 * 每页展示行数
	 */
	private Integer pageRows;

}
