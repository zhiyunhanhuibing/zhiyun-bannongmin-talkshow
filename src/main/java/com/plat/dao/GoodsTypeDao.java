package com.plat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.plat.bean.GoodsType;
import com.plat.bean.Tree;

/**
 * 商品类型dao
 * @author CR
 *
 */
public interface GoodsTypeDao {
	/**
	 * 添加商品类型
	 * @param gt
	 * @return
	 */
	public int addGoodsType(GoodsType gt);
	/**
	 * 删除商品类型
	 * @param ids
	 * @return
	 */
	public int delGoodsType(@Param("ids") List<String> ids);
	/**
	 * 修改商品类型
	 * @param gt
	 * @return
	 */
    public int modifyGoodsType(GoodsType gt);
    /**
     * 查询商品类型
     * @return
     */
    public List<Tree> queryGoodsType(@Param("type") String goodsType);
}
