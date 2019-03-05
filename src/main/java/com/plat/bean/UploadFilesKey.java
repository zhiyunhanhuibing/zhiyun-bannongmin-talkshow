package com.plat.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 文件上传表主键Bean
 * @author CR
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UploadFilesKey implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 文件类型
	 */
	private String fileType;
	/**
	 * 文件名称
	 */
	private String fileName;
	/**
	 * 文件原始名称
	 */
	private String fileOriginalName;
	
	/**
	 * 文件地址
	 */
	private String filePath;
}
