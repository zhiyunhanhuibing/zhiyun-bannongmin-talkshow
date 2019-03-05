package com.plat.bean;

import java.io.Serializable;

import lombok.Data;

/**
 * 文件处理入参Bean
 * @author CR
 *
 */
@Data
public class FileReq implements Serializable{
	private static final long serialVersionUID = 1L;
	private String filePath;
	private String fileName;
}
