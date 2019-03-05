package com.plat.dao;

import java.util.List;

import com.plat.bean.UserReq;
import com.plat.bean.UserResp;

/**
 * 查询小程序用户及用户相关信息相关dao
 * @author CR
 *
 */
public interface UserDao {	
	/**
	 * 查询用户基本信息
	 * @param req
	 * @return
	 */
	public List<UserResp> queryUserInfo(UserReq req);
}
