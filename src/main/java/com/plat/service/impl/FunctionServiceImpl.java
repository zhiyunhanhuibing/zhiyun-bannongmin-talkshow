package com.plat.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.StringUtil;
import com.plat.bean.Function;
import com.plat.bean.FunctionKey;
import com.plat.bean.FunctionTree;
import com.plat.bean.OperationDbMessage;
import com.plat.bean.RoleFunction;
import com.plat.constant.FunctionErrors;
import com.plat.dao.FunctionDao;
import com.plat.exception.PlatException;
import com.plat.service.FunctionService;

/**
 * 操作页面功能Service实现类
 * 
 * @author CR
 *
 */
@Service
public class FunctionServiceImpl implements FunctionService {
	@Autowired
	private FunctionDao dao;

	@Override
	public OperationDbMessage addFunction(Function fun) {
		OperationDbMessage odm = new OperationDbMessage();
		try {
			int count = dao.addFunction(fun);
			if (count == 0) {
				throw new PlatException(FunctionErrors.ADD_FUNCTION_ERROR, "添加页面功能");
			}
			odm.setStatusCode(200);
			odm.setStatusMessage("添加成功！");
		} catch (Exception e) {
			throw new PlatException(FunctionErrors.ADD_FUNCTION_ERROR, "添加页面功能", e);
		}
		return odm;
	}

	@Override
	public OperationDbMessage modifyFunction(Function fun) {
		OperationDbMessage odm = new OperationDbMessage();
		try {
			int count = dao.modifyFunction(fun);
			if (count == 0) {
				throw new PlatException(FunctionErrors.UPDATE_FUNCTION_ERROR, "修改页面功能");
			}
			odm.setStatusCode(200);
			odm.setStatusMessage("修改成功！");
		} catch (Exception e) {
			throw new PlatException(FunctionErrors.UPDATE_FUNCTION_ERROR, "修改页面功能", e);
		}
		return odm;
	}

	@Override
	public OperationDbMessage delFunction(FunctionKey funKey) {
		OperationDbMessage odm = new OperationDbMessage();
		try {
			int count = dao.delFunction(funKey);
			if (count == 0) {
				throw new PlatException(FunctionErrors.DEL_FUNCTION_ERROR, "删除页面功能");
			}
			odm.setStatusCode(200);
			odm.setStatusMessage("删除成功！");
		} catch (Exception e) {
			throw new PlatException(FunctionErrors.DEL_FUNCTION_ERROR, "删除页面功能", e);
		}
		return odm;
	}

	@SuppressWarnings("static-access")
	@Override
	public List<FunctionTree> queryFunction(List<Integer> ids) {
		List<FunctionTree> li = new ArrayList<>();
		try {
			List<FunctionTree> liQuery = dao.queryFunction(ids);
			if (Objects.isNull(liQuery) || liQuery.isEmpty()) {
				return li;
			}

			// 一级栏目
			for (FunctionTree tree : liQuery) {
				if (tree.getParentId() == 0) {
					li.add(tree);
				}
			}
			// 遍历得到下级栏目
			for (FunctionTree tree : li) {
				tree.setChildren(FunctionServiceImpl.getChild(tree.getId(), liQuery));
			}
		} catch (Exception e) {
			throw new PlatException(FunctionErrors.QUERY_FUNCTION_ERROR, "查询页面功能", e);
		}
		return li;
	}

	/**
	 * 递归算法递归子节点
	 * 
	 * @param id
	 * @param rootMenu
	 * @return
	 */
	private static List<FunctionTree> getChild(int id, List<FunctionTree> rootFunction) {
		List<FunctionTree> childList = new ArrayList<>();// 存放直接子菜单
		/**
		 * 开始遍历二级菜单以及它的直接子菜单
		 */
		for (FunctionTree tree : rootFunction) {
			// 遍历所有节点，将父菜单id与传过来的id比较
			if (tree.getParentId() != 0) {
				if (id == tree.getParentId()) {// 尽量让id 在前面，因为他不会为空（数据库设计为主键），parentId 不一定都有值。
					childList.add(tree);// 相等的话说明这些使它（id）的直接子节点,加入childList
				}
			}
		}
		for (FunctionTree tree : childList) {
			List<FunctionTree> li = getChild(tree.getId(), rootFunction);
			if (!Objects.isNull(li) && !li.isEmpty()) {
				tree.setChildren(li);
			}
		}
		if (childList.size() == 0) {// 递归退出条件（走到这里childList 大小等于0 说明该节点就是最后一个）
			return null;
		}
		return childList;
	}

	/**
	 * 关联角色-功能
	 */
	@Override
	@Transactional
	public OperationDbMessage relRoleFunction(int rid, List<Integer> fids) {
		OperationDbMessage odm = new OperationDbMessage();
		StringBuffer fidStr = new StringBuffer("");
		for (Integer fid : fids) {
		    fidStr.append(";");
		    fidStr.append(fid);
		}
		try {
			// 查询判断该角色是否已经维护功能
			List<Integer> rids = new ArrayList<>();
			rids.add(rid);
			List<RoleFunction> liRf = dao.queryRoleFunction(rids);
			RoleFunction rFunc = new RoleFunction();
			rFunc.setRid(rid);
			rFunc.setFid(fidStr.toString().substring(1));
			// 已经维护
			if(!Objects.isNull(liRf) && liRf.size()>0) {
				int addCount = dao.addRoleFunction(rFunc);
				if(addCount == 0) {
					throw new PlatException(FunctionErrors.REL_ROLE_FUNCTION_ERROR, "关联角色-功能");
				}
			} else {
				int modifyCount = dao.updateRoleFunction(rFunc);
				if(modifyCount == 0) {
					throw new PlatException(FunctionErrors.REL_ROLE_FUNCTION_ERROR, "关联角色-功能");
				}
			}
			odm.setStatusCode(200);
			odm.setStatusMessage("操作成功！");
		} catch (Exception e) {
			throw new PlatException(FunctionErrors.REL_ROLE_FUNCTION_ERROR, "关联角色-功能", e);
		}
		
		return odm;
	}

	/**
	 * 
	 * 查询角色下的功能信息
	 */
	@Override
	public List<Integer> queryRoleFunction(List<Integer> rids) {
		List<Integer> liFids = new ArrayList<>();
		List<RoleFunction> liRoleFunction = dao.queryRoleFunction(rids);
		if(!Objects.isNull(liRoleFunction) && liRoleFunction.size()>0) {
			for (RoleFunction roleFunction : liRoleFunction) {
				String functions = roleFunction.getFid();
				if(StringUtil.isNotEmpty(roleFunction.getFid())) {
					String[] strs = functions.split(";");
				    for (String str : strs) {
						liFids.add(Integer.parseInt(str));
					}
				}
			}
		}
		return liFids;
	}

}
