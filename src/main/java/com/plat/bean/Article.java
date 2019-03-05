package com.plat.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;


/**
 * 文章管理
 * @author hanhuibing
 *
 */
@Data
public class Article  implements Serializable{
	private static final long serialVersionUID = -5704313103184644214L;
	/**
	 * 文章UUID
	 */
	private String article_uuid;
	/**
	 * 标题
	 */
	private String article_title;
	/**
	 * 文章内容
	 */
	private String article_content;
	/**
	 * 创建时间
	 */
	private Date createtime;
	/**
	 * 更新时间
	 */
	private Date updatetime;
}
