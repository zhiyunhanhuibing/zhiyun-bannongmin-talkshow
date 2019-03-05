package com.plat.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.alibaba.druid.util.StringUtils;
import com.plat.bean.FunctionTree;
import com.plat.bean.OperationDbMessage;
import com.plat.bean.PostRole;
import com.plat.bean.SystemUserBackForLogin;
import com.plat.bean.SystemUserLoginReq;
import com.plat.config.SysUserSesssion;
import com.plat.constant.CommonErrors;
import com.plat.constant.SystemUserLoginErrors;
import com.plat.dao.SystemUserDao;
import com.plat.exception.PlatException;
import com.plat.service.FunctionService;
import com.plat.service.PostRoleService;
import com.plat.service.SysUserRoleService;
import com.plat.service.SystemUserLoginService;

/**
 * 
 * @Description 系统用户功能
 * @author yuanhuimeng Date:2018-12-04 09:47:33
 */
@Service
public class SystemUserLoginServiceImpl implements SystemUserLoginService {

	@Autowired
	private SystemUserDao systemUserDao;

	@Autowired
	private SysUserSesssion sysUserSesssion;
	
	@Autowired
	private SysUserRoleService	sysUserRoleService;
	
	@Autowired
	private PostRoleService	postRoleService;
	
	@Autowired
	private FunctionService functionService;

	/**
	 * 系统用户登录
	 */
	@Override
	public SystemUserBackForLogin systemUserLogin(SystemUserLoginReq sysUser) {

		if (Objects.isNull(sysUser)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "系统用户登录");
			pe.setAddtionalMessage("用户登录对象为空");
			throw pe;
		}
		if (StringUtils.isEmpty(sysUser.getUserName())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "系统用户登录");
			pe.setAddtionalMessage("用户名为空");
			throw pe;
		}
		if (StringUtils.isEmpty(sysUser.getPassword())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "系统用户登录");
			pe.setAddtionalMessage("密码为空");
			throw pe;
		}

		SystemUserBackForLogin systemUser = null;
		try {
			String password = sysUser.getPassword();
			// 密码加密
			sysUser.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
			systemUser = systemUserDao.getSystemUser(sysUser);

			// 登陆成功之后数据添加进session中
			this.addSession(systemUser);

			if (Objects.isNull(systemUser)) {
				throw new PlatException(SystemUserLoginErrors.SYSUSER_LOGIN_FAIL_ERROR, "系统用户登录");
			}
			
			List<String> roleNames = new ArrayList<>();
			//根据用户ID取得对应的角色ID
			List<Integer> roleIds = sysUserRoleService.getRoleByUserId(systemUser.getId());
			//根据角色ID取得功能ID
			List<Integer> functionIds = new ArrayList<>();
			//根据功能ID取得功能信息
			List<FunctionTree> functions = new ArrayList<>();
			
			//根据角色ID获得相应的角色信息
			if(!Objects.isNull(roleIds) && roleIds.size()>0) {
				List<PostRole> postRoles = postRoleService.getPostRoleListByID(roleIds);
				for (PostRole postRole : postRoles) {
					roleNames.add(postRole.getRoleName());
				}
				functionIds = functionService.queryRoleFunction(roleIds);
				functions = functionService.queryFunction(functionIds);
			}
			
			systemUser.setFunctionTree(functions);
			systemUser.setRoleNames(roleNames);
			systemUser.setStatusCode(200);
			systemUser.setStatusMessage("系统用户登录成功！");
		} catch (Exception e) {
			throw new PlatException(SystemUserLoginErrors.SYSUSER_LOGIN_FAIL_ERROR, "系统用户登录", e);
		}
		return systemUser;
	}

	/**
	 * 将登录的用户存入session
	 * 
	 * @param userInfoModel
	 */
	public void addSession(SystemUserBackForLogin userInfo) {
		sysUserSesssion.setId(userInfo.getId());
		sysUserSesssion.setUserName(userInfo.getUserName());
	}

	/**
	 * 退出登录
	 */
	@Override
	public OperationDbMessage systemUserExit() {

		OperationDbMessage message = new OperationDbMessage();
		// 清空session
		sysUserSesssion.setId(null);
		sysUserSesssion.setUserName(null);
		// 记录消息传给前台
		message.setStatusCode(200);
		message.setStatusMessage("系统用户退出成功！");
		return message;
	}
}
