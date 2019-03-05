package com.plat.service;

import com.plat.bean.CollectGoodsAddressReq;
import com.plat.bean.CollectGoodsAddressResp;
import com.plat.config.PageBean;

/**
 * 收货地址service
 * @author CR
 *
 */
public interface CollectGoodsAddressService {
	/**
	 * 查询收货地址
	 * @param req
	 * @return
	 */
	public PageBean<CollectGoodsAddressResp> queryCollectGoodsAddress(CollectGoodsAddressReq req);
}
