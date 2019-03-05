package com.plat.service;

import java.util.List;

import com.plat.bean.OperationDbMessage;
import com.plat.bean.SystemUser;
import com.plat.bean.SystemUserReq;
import com.plat.bean.SystemUserSerch;
import com.plat.config.PageBean;

/**
 * 
 * @Description 系统用户管理
 * @author yuanhuimeng Date:2018-12-04 14:19:58
 */
public interface SystemUserService {

	/**
	 * 
	 * @Description：系统用户列表
	 * @author yuanhuimeng
	 * Date:2018-12-05 14:45:02
	 */
	public PageBean<SystemUser> getSystemUserList(SystemUserSerch sysUser);

	/**
	 * 
	 * @Description：新增系统用户
	 * @author yuanhuimeng
	 * Date:2018-12-05 15:40:40
	 */
	public OperationDbMessage addSystemUser(SystemUserReq sysUser);
	
	/**
	 * 
	 * @Description：删除系统用户
	 * @author yuanhuimeng
	 * Date:2018-12-05 15:56:26
	 */
	public OperationDbMessage delSystemUser(List<String> ids);
	
	/**
	 * 
	 * @Description：修改系统用户
	 * @author yuanhuimeng
	 * Date:2018-12-05 15:56:26
	 */
	public OperationDbMessage modifySystemUser(SystemUserReq sysUser);
}
