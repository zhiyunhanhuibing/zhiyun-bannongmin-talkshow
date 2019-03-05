package com.plat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.plat.bean.CollectGoodsAddressReq;
import com.plat.bean.CollectGoodsAddressResp;

/**
 * 收货地址管理DAO
 * @author Administrator
 *
 */
public interface CollectGoodsAddressDao {
	/**
	 * 查询收货地址
	 * @param req
	 * @return
	 */
	public List<CollectGoodsAddressResp> queryCollectGoodsAddress(CollectGoodsAddressReq req);
	
	/**
	 * 增加收货地址
	 * @param req
	 * @return
	 */
	public int addCollectGoodsAddress(CollectGoodsAddressReq req);
	
	/**
	 * 删除收货地址
	 * @param req
	 * @return
	 */
	public int delCollectGoodsAddress(@Param("ids") List<String> ids);
	
	
	/**
	 * 修改收货地址
	 * @param req
	 * @return
	 */
	public int modifyCollectGoodsAddress(CollectGoodsAddressReq req);
}
