package com.plat.constant;

import com.plat.exception.ErrorEnumInterface;
import com.plat.exception.ErrorInfo;

import lombok.Getter;

/**
 * 商品异常信息
 * @author Administrator
 *
 */
public enum UploadFilesErrors  implements ErrorEnumInterface{
	/**
	 * "0500001","保存上传文件信息出错！"
	 */
    UPLOAD_FILES_ADD_ERROR(new ErrorInfo("0500001","保存上传文件信息出错！")),
	/**
	 * "0500002","删除文件信息出错！"
	 */
    UPLOAD_FILES_DEL_ERROR(new ErrorInfo("0500002","删除文件信息出错！")),
	/**
	 * "0500003","修改上传文件信息出错！"
	 */
    UPLOAD_FILES_UPDATE_ERROR(new ErrorInfo("0500003","修改上传文件信息出错！"));
	
	@Getter
	private ErrorInfo errorInfo;
	UploadFilesErrors(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}
}
