package com.plat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plat.bean.OperationDbMessage;
import com.plat.constant.CommonErrors;
import com.plat.exception.PlatException;
import com.plat.service.SysUserRoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user-role")
@Api(value = "用户-角色管理接口", tags = "用户-角色管理接口")
public class SysUserRoleController {

	@Autowired
	private SysUserRoleService	sysUserRoleService;
	
	/**
	 * 
	 * @Description：根据角色ID查询用户ID
	 * @author yuanhuimeng
	 * Date:2019-01-08 09:40:46
	 */
	@RequestMapping(value = "/getUserId", method = RequestMethod.POST)
	@ApiOperation(value = "根据角色ID查询用户ID", notes = "根据角色ID查询用户ID")
	public List<String> getUserIdForRoleId(@RequestParam("rid") int rid){
		
		if(rid <= 0) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "查询用户角色信息");
			pe.setAddtionalMessage("入参【rid】有误！");
			throw pe;
		}
		List<String> userIdList = sysUserRoleService.getUserIdForRoleId(rid);
		
		return userIdList;
	}
	
	/**
	 * 
	 * @Description：保存角色相应的用户ID
	 * @author yuanhuimeng
	 * Date:2019-01-08 10:33:38
	 */
	@RequestMapping(value = "/saveUserId", method = RequestMethod.POST)
	@ApiOperation(value = "保存角色相应的用户ID", notes = "保存角色相应的用户ID")
	public OperationDbMessage saveUserIdToUserRole(@RequestBody List<String> ids,@RequestParam("rid") int rid) {
		
		if(rid <= 0) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "入参角色ID有误");
			pe.setAddtionalMessage("入参【rid】有误！");
			throw pe;
		}
		if(ids ==  null || ids.equals("")) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "入参用户ID有误");
			pe.setAddtionalMessage("入参用户【UserId】有误！");
			throw pe;
		}
		return sysUserRoleService.saveUserIdToUserRole(ids, rid);
	}
}
