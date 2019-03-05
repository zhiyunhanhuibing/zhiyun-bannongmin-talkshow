package com.plat.service;

import org.springframework.web.multipart.MultipartFile;

import com.plat.bean.FileBean;
import com.plat.bean.FileReq;
import com.plat.bean.OperationDbMessage;

/**
 * 文件相关类
 * @author CR
 *
 */
public interface FileService {
	/**
	 * 文件上传
	 * @param file
	 * @return
	 */
	public FileBean uploadFile(MultipartFile file);
	
	/**
	 * 文件删除
	 * @param fileR
	 * @return
	 */
	public OperationDbMessage deleteFile(FileReq fileR);
}
