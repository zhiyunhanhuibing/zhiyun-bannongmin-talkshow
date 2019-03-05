package com.plat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.plat.bean.Function;
import com.plat.bean.FunctionKey;
import com.plat.bean.FunctionTree;
import com.plat.bean.RoleFunction;

/**
 * 操作功能DAO
 * @author CR
 *
 */
public interface FunctionDao {
	/**
	 * 增加功能
	 * @param fun
	 * @return
	 */
	int addFunction(Function fun);
	
	/**
	 * 修改功能
	 * @param fun
	 * @return
	 */
	int modifyFunction(Function fun);
	
	/**
	 * 删除功能
	 * @param funKey
	 * @return
	 */
	int delFunction(FunctionKey funKey);
	
	/**
	 * 查询功能
	 * @return
	 */
	List<FunctionTree> queryFunction(@Param("ids") List<Integer> ids);
	/**
	 * 添加角色-功能关联关系
	 * @param rf
	 * @return
	 */
	int addRoleFunction(RoleFunction rf);
	/**
	 * 通过角色编号查询关联信息
	 * @param rid
	 * @return
	 */
	List<RoleFunction> queryRoleFunction(@Param("rids") List<Integer> rids);
	/**
	 * 修改角色-功能关联信息
	 * @param rf
	 * @return
	 */
	int updateRoleFunction(RoleFunction rf);
}
