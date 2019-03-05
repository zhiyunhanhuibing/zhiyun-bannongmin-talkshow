package com.plat.dao;

import java.util.List;

import com.plat.bean.SysUserRole;

public interface SysUserRoleDao {

	public SysUserRole getUserIdForRoleId(int rid);

	public int addSysUserRole(SysUserRole sysUserRole);
	
	public int modifySysUserRole(SysUserRole sysUserRole);
	
	public List<SysUserRole> getRoleByUserId(String uid);
}
