package com.plat.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.plat.bean.OperationDbMessage;
import com.plat.bean.PostRole;
import com.plat.bean.PostRoleReq;
import com.plat.config.PageBean;
import com.plat.constant.PostRoleErrors;
import com.plat.dao.PostRoleDao;
import com.plat.exception.PlatException;
import com.plat.service.PostRoleService;

/**
 * 
 * @Description 岗位（角色）管理
 * @author yuanhuimeng Date:2019-01-04 15:06:04
 */
@Service
public class PostRoleServiceImpl implements PostRoleService {

	@Autowired
	private PostRoleDao postRoleDao;

	@Override
	public PageBean<PostRole> getPostRoleList(PostRoleReq postRole) {

		Integer pageIndex = postRole.getPageIndex();
		Integer pageRows = postRole.getPageRows();
		// 默认第一页，每页15条
		if (Objects.isNull(pageIndex) || pageIndex < 1) {
			pageIndex = 1;
		}
		if (Objects.isNull(pageRows) || pageRows < 1) {
			pageRows = 15;
		}
		PageHelper.startPage(pageIndex, pageRows);
		List<PostRole> postRoleList = postRoleDao.getPostRoleList(postRole);
		int countIndex = postRoleList.size();
		return new PageBean<>(pageIndex, pageRows, countIndex, postRoleList);
	}

	@Override
	public OperationDbMessage addPostRole(PostRoleReq postRole) {

		OperationDbMessage message = new OperationDbMessage();
		try {
			int addCount = postRoleDao.addPostRole(postRole);
			if (addCount == 0) {
				throw new PlatException(PostRoleErrors.POSTROLE_ADD_ERROR, "添加角色信息");
			}
			message.setStatusCode(200);
			message.setStatusMessage("添加角色成功！");
		} catch (Exception e) {
			e.printStackTrace();
			throw new PlatException(PostRoleErrors.POSTROLE_ADD_ERROR, "添加角色信息", e);
		}
		return message;
	}

	@Override
	public OperationDbMessage modifyPostRole(PostRole postRole) {

		OperationDbMessage message = new OperationDbMessage();
		try {
			int updateCount = postRoleDao.modifyPostRole(postRole);
			if (updateCount == 0) {
				throw new PlatException(PostRoleErrors.POSTROLE_UPDATE_ERROR, "修改角色信息");
			}
			message.setStatusCode(200);
			message.setStatusMessage("修改角色成功！");
			return message;
		} catch (Exception e) {
			System.out.println(e);
			throw new PlatException(PostRoleErrors.POSTROLE_UPDATE_ERROR, "修改角色信息", e);
		}
	}

	@Override
	public OperationDbMessage delPostRole(List<String> ids) {

		OperationDbMessage message = new OperationDbMessage();
		try {
			int delCount = postRoleDao.delPostRole(ids);
			if (delCount == 0) {
				throw new PlatException(PostRoleErrors.POSTROLE_DEL_ERROR, "删除角色信息");
			}
			message.setStatusCode(200);
			message.setStatusMessage("删除角色信息成功！");
		} catch (Exception e) {
			e.printStackTrace();
			throw new PlatException(PostRoleErrors.POSTROLE_DEL_ERROR, "删除角色信息", e);
		}
		return message;
	}

	@Override
	public List<PostRole> getPostRoleListByID(List<Integer> roleIds) {

		return postRoleDao.getPostRoleListByID(roleIds);
	}

}
