package com.plat.service;

import java.util.List;

import com.plat.bean.Function;
import com.plat.bean.FunctionKey;
import com.plat.bean.FunctionTree;
import com.plat.bean.OperationDbMessage;

/**
 * 
 * @author CR
 *
 */
public interface FunctionService {
	/**
	 * 添加页面功能
	 * @param fun
	 * @return
	 */
	OperationDbMessage addFunction(Function fun);
	/**
	 * 修改页面功能
	 * @param fun
	 * @return
	 */
	OperationDbMessage modifyFunction(Function fun);
	/**
	 * 删除页面功能
	 * @param funKey
	 * @return
	 */
	OperationDbMessage delFunction(FunctionKey funKey);
	/**
	 * 查询页面功能
	 * @param ids
	 * @return
	 */
	List<FunctionTree> queryFunction(List<Integer> ids);
	/**
	 * 关联角色-功能
	 * @param rf
	 * @return
	 */
	OperationDbMessage relRoleFunction(int rid, List<Integer> fids);
	/**
	 * 查询角色-功能关联信息
	 * @param rids
	 * @return
	 */
	List<Integer> queryRoleFunction(List<Integer> rids);
}
