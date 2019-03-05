package com.plat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.plat.bean.CollectGoodsAddressReq;
import com.plat.bean.CollectGoodsAddressResp;
import com.plat.config.PageBean;
import com.plat.service.CollectGoodsAddressService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 收货地址管理控制器
 * @author CR
 *
 */
@RestController
@RequestMapping("/address")
@Api(value="收货地址管理", tags="收货地址管理控制器")
public class AddressController {
	@Autowired
	private CollectGoodsAddressService service;
	
	@PostMapping("/query")
	@ApiOperation(value="查询收货地址", notes="分页查询收货地址")
	public PageBean<CollectGoodsAddressResp> queryCollectGoodsAddress(@RequestBody CollectGoodsAddressReq req) {
		return service.queryCollectGoodsAddress(req);
	}
}
