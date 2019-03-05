package com.plat.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.plat.bean.FileBean;
import com.plat.bean.FileReq;
import com.plat.bean.OperationDbMessage;
import com.plat.constant.FileErrors;
import com.plat.constant.PropertiesConstant;
import com.plat.exception.PlatException;
import com.plat.service.FileService;

import lombok.extern.slf4j.Slf4j;

/**
 * 文件处理相关serviceImpl
 * @author Administrator
 *
 */
@Service
@Slf4j
public class FileServiceImpl implements FileService{
	/**
	 * 获取配置文件配置数据
	 */
	@Autowired
	private PropertiesConstant proConstant;
	/**
	 * 文件上传
	 */
	@Override
	public FileBean uploadFile(MultipartFile file) {
		FileBean fileBean = new FileBean();
		if(file.isEmpty()) {
			throw new PlatException(FileErrors.NOTHING_FILE_ERROR, "文件上传");
		}
		// 文件原名
		String fileName = file.getOriginalFilename();
		// 文件后缀
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		// 检查文件是否合法
		this.checkSuffixName(suffixName);
		// 文件存储目录
		String fileUpName = UUID.randomUUID().toString().replaceAll("-", "")+suffixName;
		String fileXdUrl = "/"+this.getDateStr()+"/"+fileUpName;
		String filePath = proConstant.getFilePath()+fileXdUrl;
		File fileAddress = new File(filePath);
		if(!fileAddress.getParentFile().exists()) {
			fileAddress.getParentFile().mkdirs();
		}
		try {
			file.transferTo(fileAddress);
			fileBean.setStatusCode(200);
			fileBean.setStatusMessage("上传成功！");
			fileBean.setFileName(fileUpName);
			fileBean.setFileOldName(fileName);
			fileBean.setFilePath(proConstant.getFileUrl()+fileXdUrl);
		} catch (Exception e) {
			log.error("{}", "文件上传失败,失败理由:", e);
			throw new PlatException(FileErrors.UPLOAD_FILE_FAILED, "文件上传",e);
		}
		return fileBean;
	}
	

	/**
	 * 文件删除
	 */
	@Override
	@Transactional
	public OperationDbMessage deleteFile(FileReq fileR) {
		OperationDbMessage odm = new OperationDbMessage();
		// 上传链接（文件服务器中文件请求地址）
		String fileUrl = fileR.getFilePath();
		String fileServerPath = proConstant.getFilePath()+fileUrl.replaceAll(proConstant.getFileUrl(), "");
		System.out.println(fileServerPath);
		File file = new File(fileServerPath);
		if(!file.exists()) {
			throw new PlatException(FileErrors.NO_FILE_ERROR, "文件删除");
		}
		try {
			file.delete();
			odm.setStatusCode(200);
			odm.setStatusMessage("文件删除成功！");
		} catch (Exception e) {
			throw new PlatException(FileErrors.DELETE_FILE_FAILED, "文件删除", e);
		}
		
		return odm;
	}
	
	/**
	 * 检查上传文件的合法性
	 * @param suffixName
	 */
	private void checkSuffixName(String suffixName) {
		String suffixNames = proConstant.getSuffixName();
		if(suffixNames.indexOf(suffixName)==-1) {
			throw new PlatException(FileErrors.ILLEGAL_FILE_ERROR, "文件上传");
		}
	}
	/**
	 * 获取日期串
	 */
	private String getDateStr() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
}
