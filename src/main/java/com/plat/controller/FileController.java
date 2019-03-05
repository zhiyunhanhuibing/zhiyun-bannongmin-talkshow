package com.plat.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.StringUtil;
import com.plat.bean.FileBean;
import com.plat.bean.FileReq;
import com.plat.bean.OperationDbMessage;
import com.plat.constant.FileErrors;
import com.plat.exception.PlatException;
import com.plat.service.FileService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 文件相关接口类
 * @author CR
 *
 */
@RestController
@RequestMapping("/file")
@Api(value="文件处理", tags="文件处理接口")
public class FileController {
	@Autowired
	private FileService service;
	
	@PostMapping("/upload")
	@ApiOperation(value="文件上传", notes="文件上传接口\r\n可上传.jpg;.png;.jpeg;.JPG;.PNG;.JPEG等格式文件")
	public FileBean uploadFile(@RequestBody MultipartFile file) {
		if(Objects.isNull(file)) {
			throw new PlatException(FileErrors.REQ_PARAMETER_ERROR, "文件上传");
		}
		return service.uploadFile(file);
	}
	
	@PostMapping("/delete")
	@ApiOperation(value="文件删除", notes="文件删除接口\r\n文件服务器请求地址为必传参数")
	public OperationDbMessage deleteFile(@RequestBody FileReq fileR) {
		if(Objects.isNull(fileR)) {
			throw new PlatException(FileErrors.REQ_PARAMETER_ERROR, "文件删除");
		}
		if(StringUtil.isEmpty(fileR.getFilePath())) {
			throw new PlatException(FileErrors.REQ_PARAMETER_ERROR, "文件删除");
		}
		return service.deleteFile(fileR);
	}
	
}
