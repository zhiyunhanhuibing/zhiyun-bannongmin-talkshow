package com.plat.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 文件上传表实体类
 * @author CR
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class UploadFiles extends UploadFilesKey{
	private static final long serialVersionUID = 1L;
	private String showStartTime;
	private String showEndTime;
	private String url;
	private String createTime;
	private String updateTime;
    /**
     * 修改文件之前上一次上传的文件名
     */
	private String fileOldName;
}
