package com.plat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.plat.bean.UserReq;
import com.plat.bean.UserResp;
import com.plat.config.PageBean;
import com.plat.dao.UserDao;
import com.plat.service.UserService;

/**
 * 查询小程序用户相关信息
 * @author Administrator
 *
 */
@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserDao dao;
	/**
	 * 查询用户相关信息
	 */
	@Override
	public PageBean<UserResp> queryUserInfo(UserReq req) {
		int pageIndex = req.getPageIndex();
		int pageRows = req.getPageRows();
		if(pageIndex<=0) {
			pageIndex = 1;
		}
		if(pageRows<=0) {
			pageRows = 15;
		}
		PageHelper.startPage(pageIndex, pageRows);
		List<UserResp> liItems = dao.queryUserInfo(req);
		int countIndex = liItems.size();
		return new PageBean<>(pageIndex, pageRows, countIndex, liItems);
	}

}
