package com.plat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.plat.bean.OperationDbMessage;
import com.plat.bean.SystemUserBackForLogin;
import com.plat.bean.SystemUserLoginReq;
import com.plat.service.SystemUserLoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @Description 系统用户操作
 * @author yuanhuimeng Date:2018-12-04 11:28:13
 */
@RestController
@RequestMapping("/system-user-login")
@Api(value = "系统用户管理", tags = "系统用户管理")
public class SystemUserLoginController {

	@Autowired
	private SystemUserLoginService systemUserLoginService;

	/**
	 * 
	 * @Description：用户登录
	 * @author yuanhuimeng
	 * Date:2018-12-04 14:18:31
	 */
	@RequestMapping(value = "/sign-in", method = RequestMethod.POST)
	@ApiOperation(value="用户登录",notes="系统用户登录")
	public SystemUserBackForLogin systemUserLogin(@RequestBody SystemUserLoginReq sysUser) {

		return systemUserLoginService.systemUserLogin(sysUser);
	}
	
	/**
	 * 
	 * @Description：用户退出
	 * @author yuanhuimeng
	 * Date:2018-12-04 14:18:31
	 */
	@RequestMapping(value = "/exit", method = RequestMethod.POST)
	@ApiOperation(value="用户登出",notes="系统用户退出 ")
	public OperationDbMessage systemUserExit() {

		return systemUserLoginService.systemUserExit();
	}
}
