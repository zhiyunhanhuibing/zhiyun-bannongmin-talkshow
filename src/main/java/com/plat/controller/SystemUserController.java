package com.plat.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.StringUtil;
import com.plat.bean.OperationDbMessage;
import com.plat.bean.SystemUser;
import com.plat.bean.SystemUserReq;
import com.plat.bean.SystemUserSerch;
import com.plat.config.PageBean;
import com.plat.constant.CommonErrors;
import com.plat.exception.PlatException;
import com.plat.service.SystemUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @Description 系统用户操作
 * @author yuanhuimeng Date:2018-12-04 11:28:13
 */
@RestController
@RequestMapping("/system-user")
@Api(value = "系统用户管理", tags = "系统用户管理")
public class SystemUserController {

	@Autowired
	private SystemUserService systemUserService;

	/**
	 * 
	 * @Description：系统用户列表
	 * @author yuanhuimeng
	 * Date:2018-12-05 09:49:17
	 */
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	@ApiOperation(value="查询系统用户信息", notes="查询系统用户信息接口\r\n前台分页展示")
	public PageBean<SystemUser> getSystemUserList(@RequestBody SystemUserSerch sysUser) {

		return systemUserService.getSystemUserList(sysUser);
	}
	/**
	 * 
	 * @Description：新增系统用户信息
	 * @author yuanhuimeng
	 * Date:2018-12-05 15:55:01
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ApiOperation(value="新增系统用户信息", notes="新增系统用户信息接口")
	public OperationDbMessage addSystemUser(@RequestBody SystemUserReq sysUser) {
		
		return systemUserService.addSystemUser(sysUser);
	}
	/**
	 * 
	 * @Description：删除系统用户信息
	 * @author yuanhuimeng
	 * Date:2018-12-05 15:55:14
	 */
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	@ApiOperation(value="删除系统用户信息", notes="删除系统用户信息接口")
	public OperationDbMessage delSystemUser(@RequestBody List<String> ids) {
		if(Objects.isNull(ids)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "删除系统用户信息");
			pe.setAddtionalMessage("入参有误！");
			throw pe;
		}
		return systemUserService.delSystemUser(ids);
	}
	
	/**
	 * 
	 * @Description：修改系统用户信息
	 * @author yuanhuimeng
	 * Date:2018-12-05 15:55:14
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@ApiOperation(value="修改系统用户信息", notes="修改系统用户信息接口")
	public OperationDbMessage modifySystemUser(@RequestBody SystemUserReq sysUser) {
		if(Objects.isNull(sysUser)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改系统用户信息");
			pe.setAddtionalMessage("入参有误！");
			throw pe;
		}
		if(StringUtil.isEmpty(sysUser.getId())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改系统用户信息");
			pe.setAddtionalMessage("入参主键【id】不能为空！");
			throw pe;
		}
		return systemUserService.modifySystemUser(sysUser);
	}
}
