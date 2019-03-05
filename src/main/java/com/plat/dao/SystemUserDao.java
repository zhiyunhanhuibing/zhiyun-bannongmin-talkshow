package com.plat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.plat.bean.SystemUser;
import com.plat.bean.SystemUserBackForLogin;
import com.plat.bean.SystemUserLoginReq;
import com.plat.bean.SystemUserReq;
import com.plat.bean.SystemUserSerch;

public interface SystemUserDao {

	/**
	 * 
	 * @Description：系统登录查询
	 * @author yuanhuimeng
	 * Date:2018-12-04 16:24:30
	 */
	public SystemUserBackForLogin getSystemUser(SystemUserLoginReq sysUser);

	/**
	 * 
	 * @Description：系统用户列表
	 * @author yuanhuimeng
	 * Date:2018-12-05 14:56:49
	 */
	public List<SystemUser> getSystemUserList(SystemUserSerch sysUser);

	/**
	 * 
	 * @Description：添加系统用户
	 * @author yuanhuimeng
	 * Date:2018-12-05 15:49:40
	 */
	public int addSystemUser(SystemUserReq sysUser);
	
	/**
	 * 
	 * @Description：删除系统用户
	 * @author yuanhuimeng
	 * Date:2018-12-05 15:49:40
	 */
	public int delSystemUser(@Param("ids")List<String> ids);
	
	/**
	 * 
	 * @Description：删除系统用户
	 * @author yuanhuimeng
	 * Date:2018-12-05 15:49:40
	 */
	public int modifySystemUser(SystemUserReq sysUser);
}
