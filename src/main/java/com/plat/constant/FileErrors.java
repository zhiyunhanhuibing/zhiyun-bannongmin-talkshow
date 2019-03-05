package com.plat.constant;

import com.plat.exception.ErrorEnumInterface;
import com.plat.exception.ErrorInfo;

import lombok.Getter;

/**
 * 文件上传相关异常提示
 * @author CR
 *
 */
public enum FileErrors implements ErrorEnumInterface {
	/**
	 * "0000001","未上传文件！"
	 */
    NOTHING_FILE_ERROR(new ErrorInfo("0000001","未上传文件！")),
    /**
	 * "0000002","上传文件不合法！"
	 */
    ILLEGAL_FILE_ERROR(new ErrorInfo("0000002","上传文件不合法！")),
    /**
	 * "0000003","上传上传出现异常！"
	 */
    UPLOAD_FILE_FAILED(new ErrorInfo("0000003","上传文件出现异常！")),
    
    /**
     * "0000004","文件不存在，请检查是否已经删除！"
     */
    NO_FILE_ERROR(new ErrorInfo("0000004","文件不存在，请检查是否已经删除！")),
    
    /**
     * "0000005","入参异常！"
     */
    REQ_PARAMETER_ERROR(new ErrorInfo("0000005","入参异常！")),
    /**
     * "0000006","删除文件出现异常！"
     */
    DELETE_FILE_FAILED(new ErrorInfo("0000006","删除文件出现异常！"));

	@Getter
	private ErrorInfo errorInfo;
	
	FileErrors(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}
}
