package com.plat.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.StringUtil;
import com.plat.bean.OperationDbMessage;
import com.plat.bean.UploadFiles;
import com.plat.bean.UploadFilesKey;
import com.plat.bean.UploadFilesResp;
import com.plat.bean.WangEditor;
import com.plat.constant.CommonErrors;
import com.plat.exception.PlatException;
import com.plat.service.UploadFilesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 上传文件信息控制器
 * @author CR
 *
 */
@RestController
@RequestMapping("/upload-files-message")
@Api(value="上传文件信息", tags="上传文件信息控制器")
public class UploadFileController {
	@Autowired
	private UploadFilesService service;
	
	
	@PostMapping("/upload")
	@ApiOperation(value="添加上传文件信息", notes="添加文件上传信息接口\r\n入参文件类型、文件名称、文件原名为必传参数")
	public WangEditor upload(@RequestParam("myFile") MultipartFile multipartFile,
            HttpServletRequest request) {
		try {
            // 获取项目路径
            String realPath = request.getSession().getServletContext()
                    .getRealPath("");
            InputStream inputStream = multipartFile.getInputStream();
            String contextPath = request.getContextPath();
            // 服务器根目录的路径
            String path = realPath.replace(contextPath.substring(1), "");
            // 根目录下新建文件夹upload，存放上传图片
            String uploadPath = path + "upload";
            // 获取文件名称
            String filename ="1";
            // 将文件上传的服务器根目录下的upload文件夹
            File file = new File(uploadPath, filename);
            FileUtils.copyInputStreamToFile(inputStream, file);
            // 返回图片访问路径
            String url = request.getScheme() + "://" + request.getServerName()
                    + ":" + request.getServerPort() + "/upload/" + filename;
            
            String [] str = {url};
            WangEditor we = new WangEditor(str);
            return we;
        } catch (IOException e) {
        	PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "上传文件失败");
			pe.setAddtionalMessage("上传文件失败");
			throw pe;
        }
	}
	
	@PostMapping("/add")
	@ApiOperation(value="添加上传文件信息", notes="添加文件上传信息接口\r\n入参文件类型、文件名称、文件原名为必传参数")
	public OperationDbMessage addFiles(@RequestBody UploadFiles files) {
		if(Objects.isNull(files)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "添加上传文件信息");
			pe.setAddtionalMessage("入参为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(files.getFileType())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "添加上传文件信息");
			pe.setAddtionalMessage("入参文件类型【fileType】为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(files.getFileName())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "添加上传文件信息");
			pe.setAddtionalMessage("入参文件名称【fileName】为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(files.getFileOriginalName())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "添加上传文件信息");
			pe.setAddtionalMessage("入参文件原名【fileOriginalName】为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(files.getFilePath())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "添加上传文件信息");
			pe.setAddtionalMessage("入参文件请求地址【filePath】为空！");
			throw pe;
		}
		return service.addFiles(files);
	}

	@PostMapping("/del")
	@ApiOperation(value="删除上传文件信息", notes="删除上传文件信息接口\r\n单条删除\r\n入参文件类型和文件名称为必传参数")
	public OperationDbMessage delFiles(@RequestBody UploadFilesKey filesKey) {
		if(Objects.isNull(filesKey)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "删除上传文件信息");
			pe.setAddtionalMessage("入参为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(filesKey.getFileType())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "删除上传文件信息");
			pe.setAddtionalMessage("入参文件类型【fileType】为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(filesKey.getFileName())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "删除上传文件信息");
			pe.setAddtionalMessage("入参文件名称【fileName】为空！");
			throw pe;
		}
		return service.delFiles(filesKey);
	}
    @PostMapping("/modify")
    @ApiOperation(value="修改上传文件信息", notes="修改上传文件信息接口\r\n入参文件类型、文件名称、文件原名、上次上传的文件名称和文件访问地址为必传参数")
	public OperationDbMessage modifyFiles(@RequestBody UploadFiles files) {
		if(Objects.isNull(files)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改上传文件信息");
			pe.setAddtionalMessage("入参为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(files.getFileType())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改上传文件信息");
			pe.setAddtionalMessage("入参文件类型【fileType】为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(files.getFileName())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改上传文件信息");
			pe.setAddtionalMessage("入参文件名称【fileName】为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(files.getFileOriginalName())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改上传文件信息");
			pe.setAddtionalMessage("入参文件原名【fileOriginalName】为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(files.getFileOldName())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改上传文件信息");
			pe.setAddtionalMessage("入参上次上传的文件名称【fileOldName】为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(files.getFilePath())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改上传文件信息");
			pe.setAddtionalMessage("入参文件请求地址【filePath】为空！");
			throw pe;
		}
		return service.modifyFiles(files);
	}
    
    @PostMapping("/query")
    @ApiOperation(value="查询上传文件信息", notes="查询上传文件信息接口\r\n无分页\r\n入参文件类型为必传参数")
	public List<UploadFilesResp> queryFiles(@RequestBody UploadFilesKey filesKey) {
		if(Objects.isNull(filesKey)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "查询上传文件信息");
			pe.setAddtionalMessage("入参为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(filesKey.getFileType())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "查询上传文件信息");
			pe.setAddtionalMessage("入参文件类型【fileType】为空！");
			throw pe;
		}
		return service.queryFiles(filesKey);
	}
    
   
}
