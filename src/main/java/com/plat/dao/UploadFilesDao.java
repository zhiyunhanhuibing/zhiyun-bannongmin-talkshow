package com.plat.dao;

import java.util.List;


import com.plat.bean.UploadFiles;
import com.plat.bean.UploadFilesKey;
import com.plat.bean.UploadFilesResp;

/**
 * 文件上传公共表操作Dao
 * @author CR
 *
 */
public interface UploadFilesDao {
	/**
	 * 保存上传文件相关信息
	 * @param files
	 * @return
	 */
	public int addFiles(UploadFiles files);
	
	/**
	 * 删除上传文件相关信息
	 * @param liFiles
	 * @return
	 */
	public int delFiles(UploadFilesKey filesKey);
	
	/**
	 * 修改上传文件的信息
	 * @param files
	 * @return
	 */
	public int modifyFiles(UploadFiles files);
	
	/**
	 * 查询上传文件的信息
	 * @param filesKey
	 * @return
	 */
	public List<UploadFilesResp> queryFiles(UploadFilesKey filesKey);
}
