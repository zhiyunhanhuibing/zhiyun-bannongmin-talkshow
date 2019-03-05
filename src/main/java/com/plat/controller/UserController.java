package com.plat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.plat.bean.UserReq;
import com.plat.bean.UserResp;
import com.plat.config.PageBean;
import com.plat.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 小程序用户管理控制器
 * @author CR
 *
 */
@RestController
@RequestMapping("/user")
@Api(value="小程序用户管理", tags="小程序用户管理控制器")
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping("/query-user")
	@ApiOperation(value="小程序用户基本信息", notes="分页查询小程序用户基本信息接口\r\n分页查询，当前页与每页展示的条数默认为1和15")
	public PageBean<UserResp> queryCollectGoodsAddress(@RequestBody UserReq req) {
		return service.queryUserInfo(req);
	}
}
