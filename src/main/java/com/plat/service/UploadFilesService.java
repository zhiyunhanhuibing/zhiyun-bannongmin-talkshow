package com.plat.service;

import java.util.List;

import com.plat.bean.OperationDbMessage;
import com.plat.bean.UploadFiles;
import com.plat.bean.UploadFilesKey;
import com.plat.bean.UploadFilesResp;

public interface UploadFilesService {
	/**
	 * 保存上传文件相关信息
	 * @param files
	 * @return
	 */
	public OperationDbMessage addFiles(UploadFiles files);
	
	/**
	 * 删除上传文件相关信息
	 * @param liFiles
	 * @return
	 */
	public OperationDbMessage delFiles(UploadFilesKey filesKey);
	
	/**
	 * 修改上传文件的信息
	 * @param files
	 * @return
	 */
	public OperationDbMessage modifyFiles(UploadFiles files);
	
	/**
	 * 查询上传文件的信息
	 * @param filesKey
	 * @return
	 */
	public List<UploadFilesResp> queryFiles(UploadFilesKey filesKey);
}
