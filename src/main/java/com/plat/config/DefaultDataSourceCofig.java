package com.plat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;
/**
 * 数据源配置文件读取实体类
 * @author chenrong
 *
 */
@Component
@Data
public class DefaultDataSourceCofig {
	@Value("${custom.datasource.default.driver-class-name}")
	private String driverClassName;
	@Value("${custom.datasource.default.url}")
	private String url;
	@Value("${custom.datasource.default.username}") 
	private String username;
	@Value("${custom.datasource.default.password}")
	private String password;
}
