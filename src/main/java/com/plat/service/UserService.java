package com.plat.service;

import com.plat.bean.UserReq;
import com.plat.bean.UserResp;
import com.plat.config.PageBean;

/**
 * 小程序用户相关Service
 * @author Administrator
 *
 */
public interface UserService {
	/**
	 * 查询用户信息
	 * @param req
	 * @return
	 */
	public PageBean<UserResp> queryUserInfo(UserReq req);
}
