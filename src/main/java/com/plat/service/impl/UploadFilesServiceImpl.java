package com.plat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plat.bean.FileReq;
import com.plat.bean.OperationDbMessage;
import com.plat.bean.UploadFiles;
import com.plat.bean.UploadFilesKey;
import com.plat.bean.UploadFilesResp;
import com.plat.constant.UploadFilesErrors;
import com.plat.dao.UploadFilesDao;
import com.plat.exception.PlatException;
import com.plat.service.FileService;
import com.plat.service.UploadFilesService;

/**
 * 文件上传记录Service
 * @author Administrator
 *
 */
@Service
public class UploadFilesServiceImpl implements UploadFilesService{
	@Autowired
	private UploadFilesDao dao;
	@Autowired 
	private FileService fileService;
	
	@Override
	@Transactional
	public OperationDbMessage addFiles(UploadFiles files) {
		OperationDbMessage odm = new OperationDbMessage();
		try {
			int addCount = dao.addFiles(files);
			if(addCount == 0) {
				throw new PlatException(UploadFilesErrors.UPLOAD_FILES_ADD_ERROR, "保存上传文件信息");
			}
			odm.setStatusCode(200);
			odm.setStatusMessage("保存上传文件信息成功！");
		} catch (Exception e) {
			throw new PlatException(UploadFilesErrors.UPLOAD_FILES_ADD_ERROR, "保存上传文件信息", e);
		}
		return odm;
	}

	@Override
	@Transactional
	public OperationDbMessage delFiles(UploadFilesKey filesKey) {
		OperationDbMessage odm = new OperationDbMessage();
		try {
			int delCount = dao.delFiles(filesKey);
			if(delCount == 0) {
				throw new PlatException(UploadFilesErrors.UPLOAD_FILES_DEL_ERROR, "删除上传文件信息");
			}
			// 删除上传的文件
			FileReq fileR = new FileReq();
			fileR.setFileName(filesKey.getFileName());
			fileR.setFilePath(filesKey.getFilePath());
			fileService.deleteFile(fileR);
			odm.setStatusCode(200);
			odm.setStatusMessage("删除上传文件信息成功！");
		}catch (Exception e) {
			throw new PlatException(UploadFilesErrors.UPLOAD_FILES_DEL_ERROR, "删除上传文件信息", e);
		}
		return odm;
	}

	@Override
	public OperationDbMessage modifyFiles(UploadFiles files) {
		OperationDbMessage odm = new OperationDbMessage();
		try {
			int modifyCount = dao.modifyFiles(files);
			if(modifyCount == 0) {
				throw new PlatException(UploadFilesErrors.UPLOAD_FILES_UPDATE_ERROR, "修改上传文件信息");
			}
			odm.setStatusCode(200);
			odm.setStatusMessage("修改上传文件信息成功！");
		} catch (Exception e) {
			throw new PlatException(UploadFilesErrors.UPLOAD_FILES_UPDATE_ERROR, "修改上传文件信息", e);
		}
		return odm;
	}

	@Override
	public List<UploadFilesResp> queryFiles(UploadFilesKey filesKey) {
		return dao.queryFiles(filesKey);
	}
    
}
