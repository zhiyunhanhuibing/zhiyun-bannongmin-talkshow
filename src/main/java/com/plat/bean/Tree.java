package com.plat.bean;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 栏目树
 * @author Administrator
 *
 */
@Data
public class Tree implements Serializable{
	private static final long serialVersionUID = 7405308915220763225L;
	private String id;
	private String code;
	private String name;
	private String describe;
	private String parentId;	
	private String fileName;
	private String fileOriginalName;
	private String filePath;
	@SuppressWarnings("rawtypes")
	private List children;
}
