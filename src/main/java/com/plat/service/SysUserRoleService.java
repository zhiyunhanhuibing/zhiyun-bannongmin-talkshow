package com.plat.service;

import java.util.List;

import com.plat.bean.OperationDbMessage;

public interface SysUserRoleService {

	/**
	 * 
	 * @Description：根据角色ID查询用户ID
	 * @author yuanhuimeng
	 * Date:2019-01-08 10:29:56
	 */
	public List<String> getUserIdForRoleId(int rid);
	
	/**
	 * 
	 * @Description：保存角色相应的用户ID
	 * @author yuanhuimeng
	 * Date:2019-01-08 10:33:23
	 */
	public OperationDbMessage saveUserIdToUserRole(List<String> ids, int rid);
	
	/**
	 * 
	 * @Description：TODO 根据用户ID查询相应的角色ID
	 * @author yuanhuimeng
	 * Date:2019-01-09 15:27:45
	 */
	public List<Integer> getRoleByUserId(String uid);
}
