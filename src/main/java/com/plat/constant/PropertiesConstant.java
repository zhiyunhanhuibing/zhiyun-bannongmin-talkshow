package com.plat.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 配置文件配置常量读取公共类
 * @author CR
 *
 */
@Data
@Component
public class PropertiesConstant {
	/**
	 * 文件路径
	 */
	@Value("${file.path}")
	private String filePath;
	/**
	 * 文件链接
	 */
	@Value("${file.url}")
	private String fileUrl;
	
	/**
	 * 可支持上传文件后缀
	 */
	@Value("${file.suffixName}")
	private String suffixName;
}
