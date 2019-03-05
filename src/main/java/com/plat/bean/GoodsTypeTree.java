package com.plat.bean;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 栏目树
 * @author Administrator
 *
 */
@Data
public class GoodsTypeTree implements Serializable{
	private static final long serialVersionUID = 7405308915220763225L;
	private String id;
	private String type;
	private String typeName;
	private String parentId;
	
	@Data
	@EqualsAndHashCode(callSuper = false)
	public class GoodsTypeTrees extends GoodsTypeTree{
		private static final long serialVersionUID = 1L;
		private List<GoodsTypeTree> children;
	}
}
