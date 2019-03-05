package com.plat.service;

import java.util.List;

import com.plat.bean.OperationDbMessage;
import com.plat.bean.PostRole;
import com.plat.bean.PostRoleReq;
import com.plat.config.PageBean;

/**
 * 
 * @Description 岗位（角色）管理
 * @author yuanhuimeng Date:2019-01-04 14:49:50
 */
public interface PostRoleService {

	/**
	 * 
	 * @Description：角色信息列表
	 * @author yuanhuimeng
	 * Date:2019-01-04 16:01:26
	 */
	public PageBean<PostRole> getPostRoleList(PostRoleReq postRole);

	/**
	 * 
	 * @Description：添加角色信息
	 * @author yuanhuimeng
	 * Date:2019-01-07 09:29:19
	 */
	public OperationDbMessage addPostRole(PostRoleReq postRole);

	/**
	 * 
	 * @Description：TODO 修改角色信息
	 * @author yuanhuimeng
	 * Date:2019-01-07 10:08:17
	 */
	public OperationDbMessage modifyPostRole(PostRole postRole);

	/**
	 * 删除角色信息
	 * @Description：TODO(这里描述方法的作用)
	 * @author yuanhuimeng
	 * Date:2019-01-07 10:09:44
	 */
	public OperationDbMessage delPostRole(List<String> ids);
	
	/**
	 * 
	 * @Description：TODO 根据ID取得所有角色信息
	 * @author yuanhuimeng
	 * Date:2019-01-10 08:59:11
	 */
	public List<PostRole> getPostRoleListByID(List<Integer> roleIds);
}
