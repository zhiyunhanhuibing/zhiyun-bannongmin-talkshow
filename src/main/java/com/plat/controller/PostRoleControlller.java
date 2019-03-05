package com.plat.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.plat.bean.OperationDbMessage;
import com.plat.bean.PostRole;
import com.plat.bean.PostRoleReq;
import com.plat.config.PageBean;
import com.plat.constant.CommonErrors;
import com.plat.exception.PlatException;
import com.plat.service.PostRoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/post-role")
@Api(value = "角色管理", tags = "角色管理")
public class PostRoleControlller {

	@Autowired
	private PostRoleService postRoleService;

	@RequestMapping(value = "/query", method = RequestMethod.POST)
	@ApiOperation(value = "角色信息", notes = "角色列表信息接口\r\n前台分页(树状)展示")
	public PageBean<PostRole> getPostRoleList(@RequestBody PostRoleReq postRole) {

		return postRoleService.getPostRoleList(postRole);
	}

	/**
	 * 
	 * @Description：TODO 添加角色信息
	 * @author yuanhuimeng Date:2019-01-07 09:46:57
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ApiOperation(value = "添加角色信息", notes = "添加角色信息接口")
	public OperationDbMessage addPostRole(@RequestBody PostRoleReq postRole) {

		return postRoleService.addPostRole(postRole);
	}

	/**
	 * 
	 * @Description：TODO(修改角色信息) @author yuanhuimeng Date:2019-01-07 09:49:10
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@ApiOperation(value = "修改角色信息", notes = "修改角色信息接口")
	public OperationDbMessage modifyPostRole(@RequestBody PostRole postRole) {
		if (Objects.isNull(postRole)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改角色信息");
			pe.setAddtionalMessage("入参有误！");
			throw pe;
		}
		if (postRole.getId() == 0) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改角色信息");
			pe.setAddtionalMessage("入参主键【id】有误！");
			throw pe;
		}
		return postRoleService.modifyPostRole(postRole);
	}

	/**
	 * 
	 * @Description：TODO 删除角色信息
	 * @author yuanhuimeng Date:2019-01-07 10:06:48
	 */
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	@ApiOperation(value = "删除角色信息", notes = "删除角色信息接口")
	public OperationDbMessage delPostRole(@RequestBody List<String> ids) {
		if (Objects.isNull(ids)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "删除角色信息");
			pe.setAddtionalMessage("入参有误！");
			throw pe;
		}
		return postRoleService.delPostRole(ids);
	}
}
