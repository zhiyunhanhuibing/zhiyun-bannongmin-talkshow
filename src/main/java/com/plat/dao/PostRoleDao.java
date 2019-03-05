package com.plat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.plat.bean.PostRole;
import com.plat.bean.PostRoleReq;

public interface PostRoleDao {

	/**
	 * 
	 * @Description：角色信息列表
	 * @author yuanhuimeng
	 * Date:2019-01-07 09:41:56
	 */
	public List<PostRole> getPostRoleList(PostRoleReq postRole);

	/**
	 * 
	 * @Description：添加角色信息
	 * @author yuanhuimeng
	 * Date:2019-01-07 09:42:14
	 */
	public int addPostRole(PostRoleReq postRole);

	/**
	 * 
	 * @Description：TODO 删除角色信息
	 * @author yuanhuimeng
	 * Date:2019-01-07 10:15:19
	 */
	public int delPostRole(@Param("ids") List<String> ids);

	/**
	 * 
	 * @Description：TODO 修改角色信息
	 * @author yuanhuimeng
	 * Date:2019-01-07 10:21:23
	 */
	public int modifyPostRole(PostRole postRole);
	
	/**
	 * 
	 * @Description：TODO 根据ID取得所有角色信息
	 * @author yuanhuimeng
	 * Date:2019-01-10 09:01:12
	 */
	public List<PostRole> getPostRoleListByID(@Param("roleIds") List<Integer> roleIds);
}
