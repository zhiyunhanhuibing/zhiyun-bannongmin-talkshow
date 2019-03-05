package com.plat.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.plat.bean.OperationDbMessage;
import com.plat.bean.SystemUser;
import com.plat.bean.SystemUserReq;
import com.plat.bean.SystemUserSerch;
import com.plat.config.PageBean;
import com.plat.constant.SystemUserErrors;
import com.plat.constant.SystemUserLoginErrors;
import com.plat.dao.SystemUserDao;
import com.plat.exception.PlatException;
import com.plat.service.SystemUserService;

/**
 * 
 * @Description 系统用户功能
 * @author yuanhuimeng Date:2018-12-04 09:47:33
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {

	@Autowired
	private SystemUserDao systemUserDao;


	/**
	 * 系统用户列表查询
	 */
	@Override
	public PageBean<SystemUser> getSystemUserList(SystemUserSerch sysUser) {

		Integer pageIndex = sysUser.getPageIndex();
		Integer pageRows = sysUser.getPageRows();
		// 默认第一页，每页15条
		if(Objects.isNull(pageIndex) || pageIndex<1) {
			pageIndex = 1;
		}
		if(Objects.isNull(pageRows) || pageRows<1) {
			pageRows = 15;
		}
		PageHelper.startPage(pageIndex, pageRows);
		List<SystemUser> systemUsers = systemUserDao.getSystemUserList(sysUser);
		int countIndex = systemUsers.size();
		return new PageBean<>(pageIndex, pageRows, countIndex, systemUsers);
	}

	/**
	 * 新增系统用户
	 */
	@Override
	@Transactional
	public OperationDbMessage addSystemUser(SystemUserReq sysUser) {

		OperationDbMessage message = new OperationDbMessage();
		try {
			//用户密码加密
			String password = sysUser.getPassword();
			sysUser.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
			int addCount = systemUserDao.addSystemUser(sysUser);
			if (addCount == 0) {
				throw new PlatException(SystemUserErrors.SYSUSER_ADD_ERROR, "添加系统用户");
			}
			message.setStatusCode(200);
			message.setStatusMessage("添加系统用户成功！");
		} catch (Exception e) {
			e.printStackTrace();
			throw new PlatException(SystemUserErrors.SYSUSER_ADD_ERROR, "添加系统用户", e);
		}
		return message;
	}

	/**
	 * 删除系统用户信息
	 * 
	 */
	@Override
	@Transactional
	public OperationDbMessage delSystemUser(List<String> ids) {

		OperationDbMessage message = new OperationDbMessage();
		try {
			int addCount = systemUserDao.delSystemUser(ids);
			if (addCount == 0) {
				throw new PlatException(SystemUserErrors.SYSUSER_DEL_ERROR, "删除系统用户");
			}
			message.setStatusCode(200);
			message.setStatusMessage("删除系统用户成功！");
		} catch (Exception e) {
			e.printStackTrace();
			throw new PlatException(SystemUserErrors.SYSUSER_DEL_ERROR, "删除系统用户", e);
		}
		return message;
	}

	/**
	 * 修改用户信息
	 */
	@Override
	@Transactional
	public OperationDbMessage modifySystemUser(SystemUserReq sysUser) {
		
		OperationDbMessage message = new OperationDbMessage();
		try {
			String password = sysUser.getPassword();
			if (StringUtils.isEmpty(sysUser.getPassword())) {
				PlatException pe = new PlatException(SystemUserLoginErrors.SYSUSER_PASSWORD_ISNULL_ERROR, "系统用户登录");
				pe.setAddtionalMessage("密码为空");
				throw pe;
			}
			//密码加密
			sysUser.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
			int updateCount = systemUserDao.modifySystemUser(sysUser);
			if(updateCount == 0) {
				throw new PlatException(SystemUserErrors.SYSUSER_UPDATE_ERROR, "修改系统用户信息");
			}
			message.setStatusCode(200);
			message.setStatusMessage("修改系统用户信息成功！");
			return message;
		} catch (Exception e) {
			System.out.println(e);
			throw new PlatException(SystemUserErrors.SYSUSER_UPDATE_ERROR, "修改系统用户信息",e);
		}	
	}
}
