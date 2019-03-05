package com.plat.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper=false)
public class FileBean extends OperationDbMessage{
	private static final long serialVersionUID = 7423338274775926851L;
	/**
	 * 文件原名
	 */
	private String fileOldName;
	/**
	 * 文件上传名称
	 */
	private String fileName;
	/**
	 * 文件链接
	 */
	private String filePath;

}
