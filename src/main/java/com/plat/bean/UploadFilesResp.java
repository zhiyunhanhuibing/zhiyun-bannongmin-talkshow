package com.plat.bean;

import java.util.Date;

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
public class UploadFilesResp extends UploadFilesKey{
	private static final long serialVersionUID = 1L;
	private Date showStartTime;
	private Date showEndTime;
	private String url;
	private Date createTime;
	private Date updateTime;
    /**
     * 修改文件之前上一次上传的文件名
     */
	private String fileOldName;
}
