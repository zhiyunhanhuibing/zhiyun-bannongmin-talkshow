package com.plat.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.plat.bean.GoodsType;
import com.plat.bean.OperationDbMessage;
import com.plat.bean.Tree;

/**
 * 商品类型管理Service
 * @author Administrator
 *
 */
public interface GoodsTypeService {
	/**
	 * 添加商品类型
	 * @param gt
	 * @return
	 */
	public OperationDbMessage addGoodsType(GoodsType gt);
	/**
	 * 删除商品类型
	 * @param ids
	 * @return
	 */
	public OperationDbMessage delGoodsType(@Param("ids") List<String> ids);
	/**
	 * 修改商品类型
	 * @param gt
	 * @return
	 */
    public OperationDbMessage modifyGoodsType(GoodsType gt);
    /**
     * 查询商品类型
     * @return
     */
    public List<Tree> queryGoodsType(String goodsType);
}
