package com.plat.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.StringUtil;
import com.plat.bean.GoodsType;
import com.plat.bean.OperationDbMessage;
import com.plat.bean.Tree;
import com.plat.constant.GoodsTypeErrors;
import com.plat.dao.GoodsTypeDao;
import com.plat.exception.PlatException;
import com.plat.service.GoodsTypeService;


/**
 * 商品类型管理ServiceImpl
 * @author Administrator
 *
 */
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService{
	@Autowired
	private GoodsTypeDao dao;
	
	/**
	 * 添加商品类型
	 */
	@Override
	@Transactional
	public OperationDbMessage addGoodsType(GoodsType gt) {
		OperationDbMessage operation = new OperationDbMessage();
		try {
			List<Tree> li = dao.queryGoodsType(gt.getType());
			if(null!=li && li.size()>0) {
				throw new PlatException(GoodsTypeErrors.IDENTICAL_GOODS_TYPE_ERROR,"添加商品类型");
			}
			int addCount = dao.addGoodsType(gt);
			if(addCount==0) {
				throw new PlatException(GoodsTypeErrors.GOODS_TYPE_ADD_ERROR, "添加商品类型");
			}
			operation.setStatusCode(200);
			operation.setStatusMessage("添加商品类型成功！");
		} catch (Exception e) {
			e.printStackTrace();
			throw new PlatException(GoodsTypeErrors.GOODS_TYPE_ADD_ERROR, "添加商品类型", e);
		}
		return operation;
	}

	/**
	 * 删除商品类型
	 */
	@Override
	@Transactional
	public OperationDbMessage delGoodsType(List<String> ids) {
		OperationDbMessage operation = new OperationDbMessage();
		try {
			int delCount = dao.delGoodsType(ids);
			if(delCount == 0) {
				throw new PlatException(GoodsTypeErrors.GOODS_TYPE_DEL_ERROR, "删除商品类型");
			}
			operation.setStatusCode(200);
			operation.setStatusMessage("删除商品类型成功！");
		} catch (Exception e) {
			throw new PlatException(GoodsTypeErrors.GOODS_TYPE_DEL_ERROR, "删除商品类型", e);
		}
		return operation;
	}

	/**
	 * 修改商品类型
	 */
	@Override
	@Transactional
	public OperationDbMessage modifyGoodsType(GoodsType gt) {
		OperationDbMessage operation = new OperationDbMessage();
		try {
			int modifyCount = dao.modifyGoodsType(gt);
			if(modifyCount == 0) {
				throw new PlatException(GoodsTypeErrors.GOODS_TYPE_UPDATE_ERROR, "修改商品类型");
			}
			operation.setStatusCode(200);
			operation.setStatusMessage("修改商品类型成功！");
		} catch (Exception e) {
			throw new PlatException(GoodsTypeErrors.GOODS_TYPE_UPDATE_ERROR, "修改商品类型", e);
		}
		return operation;
	}

	/**
	 * 查询商品类型
	 */
	@SuppressWarnings("static-access")
	@Override
	public List<Tree> queryGoodsType(String goodsType) {
		List<Tree> li = new ArrayList<>();
		try {
			List<Tree> liTree  = dao.queryGoodsType("");
			if(Objects.isNull(liTree) || liTree.isEmpty()) {
				return li;
			}
		    
			//  一级栏目
			for (Tree tree : liTree) {
				if(StringUtil.isEmpty(tree.getParentId())) {
					li.add(tree);
				}
			}
			// 遍历得到下级栏目
			for (Tree tree : li) {
				tree.setChildren(GoodsTypeServiceImpl.getChild(tree.getId(), liTree));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PlatException(GoodsTypeErrors.GOODS_TYPE_QUERY_ERROR, "查询商品类型", e);
		}
		return li;
	}

	/**
	 * 递归算法递归子节点
	 * @param id
	 * @param rootMenu
	 * @return
	 */
	 private  static  List<Tree> getChild(String id, List<Tree> rootMenu) {
	        List<Tree> childList = new ArrayList<>();//存放直接子菜单
	        /**
	         *开始遍历二级菜单以及它的直接子菜单
	         */
	        for (Tree menu : rootMenu) {
	            // 遍历所有节点，将父菜单id与传过来的id比较
	            if (StringUtil.isNotEmpty(menu.getParentId())) {
	                if (id.equals(menu.getParentId())) {//尽量让id 在前面，因为他不会为空（数据库设计为主键），parentId 不一定都有值。
	                    childList.add(menu);//相等的话说明这些使它（id）的直接子节点,加入childList
	                }
	            }
	        }
	        for (Tree menu : childList) {
	        	List<Tree> li =  getChild(menu.getId(), rootMenu);
	        	if(!Objects.isNull(li) && !li.isEmpty()) {
	        		menu.setChildren(li);
	        	}
	        }
	        if (childList.size() == 0) {// 递归退出条件（走到这里childList 大小等于0 说明该节点就是最后一个）
	            return null;
	        }
	        return childList;
	    }
}
