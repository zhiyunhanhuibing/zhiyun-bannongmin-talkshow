package com.plat.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.plat.bean.OperationDbMessage;
import com.plat.bean.SysUserRole;
import com.plat.constant.SysUserRoleErrors;
import com.plat.dao.SysUserRoleDao;
import com.plat.exception.PlatException;
import com.plat.service.SysUserRoleService;

@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

	@Autowired
	private SysUserRoleDao sysUserRoleDao;

	@Override
	public List<String> getUserIdForRoleId(int rid) {

		List<String> userIdList = new ArrayList<>();
		SysUserRole SysUserRole = sysUserRoleDao.getUserIdForRoleId(rid);
		if (ObjectUtils.isEmpty(SysUserRole)) {
			return null;
		} else {
			String userIds = SysUserRole.getUid();
			String[] userIds1 = userIds.split(";");
			for (String userId : userIds1) {
				userIdList.add(userId);
			}
			return userIdList;
		}
	}

	@Override
	public OperationDbMessage saveUserIdToUserRole(List<String> ids, int rid) {

		OperationDbMessage message = new OperationDbMessage();

		int index = ids.size() - 1;
		StringBuilder userIds = new StringBuilder();
		for (String id : ids) {
			if (ids.indexOf(id) == index) {
				userIds.append(id);
				break;
			}
			userIds.append(id).append(";");
		}

		SysUserRole SysUserRole = sysUserRoleDao.getUserIdForRoleId(rid);
		if (ObjectUtils.isEmpty(SysUserRole)) {
			SysUserRole SysUserRole1 = new SysUserRole();
			SysUserRole1.setRid(rid);
			SysUserRole1.setUid(userIds.toString());
			int addCount = sysUserRoleDao.addSysUserRole(SysUserRole1);
			if (addCount == 0) {
				throw new PlatException(SysUserRoleErrors.SYSUSER_ROLE_ADD_ERROR, "添加角色关联用户信息");
			}
			message.setStatusCode(200);
			message.setStatusMessage("添加角色成功！");
		} else {
			SysUserRole.setUid(userIds.toString());
			int modifyCount = sysUserRoleDao.modifySysUserRole(SysUserRole);
			if (modifyCount == 0) {
				throw new PlatException(SysUserRoleErrors.SYSUSER_ROLE_UPDATE_ERROR, "修改角色关联用户信息");
			}
			message.setStatusCode(200);
			message.setStatusMessage("修改角色成功！");
		}
		return message;
	}

	@Override
	public List<Integer> getRoleByUserId(String uid) {

		List<Integer> roleIds = new ArrayList<>();
		List<SysUserRole> sysUserRoles = sysUserRoleDao.getRoleByUserId(uid);
		if(!Objects.isNull(sysUserRoles) && sysUserRoles.size()>0) {
			for (SysUserRole sysUserRole : sysUserRoles) {
				roleIds.add(sysUserRole.getId());
			}
		}
		
		return roleIds;
	}

}
