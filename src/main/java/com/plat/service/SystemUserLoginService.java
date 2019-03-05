package com.plat.service;

import com.plat.bean.OperationDbMessage;
import com.plat.bean.SystemUserBackForLogin;
import com.plat.bean.SystemUserLoginReq;

/**
 * 
 * @Description 系统用户管理
 * @author yuanhuimeng
 * Date:2018-12-04 14:19:58
 */
public interface SystemUserLoginService {

	/**
	 * 
	 * @Description：用户登录
	 * @author yuanhuimeng
	 * Date:2018-12-06 15:12:12
	 */
	public SystemUserBackForLogin systemUserLogin(SystemUserLoginReq sysUser);
	
	/**
	 * 
	 * @Description：用户退出登录
	 * @author yuanhuimeng
	 * Date:2018-12-06 15:12:27
	 */
	public OperationDbMessage systemUserExit();
}
