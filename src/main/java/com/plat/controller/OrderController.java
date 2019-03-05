package com.plat.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.StringUtil;
import com.plat.bean.OrderGoods;
import com.plat.bean.OrderGoodsKey;
import com.plat.bean.OrderReq;
import com.plat.bean.OrderResp;
import com.plat.config.PageBean;
import com.plat.constant.CommonErrors;
import com.plat.exception.PlatException;
import com.plat.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 订单管理控制器
 * @author CR
 *
 */
@RestController
@RequestMapping("/order")
@Api(value="订单管理", tags="订单管理控制器")
public class OrderController {
	@Autowired
	private OrderService service;
	
	/**
	 * 查询订单信息
	 * @param req
	 * @return
	 */
	@PostMapping("/query")
	@ApiOperation(value="查询订单信息", notes="分页查询订单信息\r\n当前页、每页展示的条数未传参默认为1和15\r\n返回数据默认按照订单入库时间倒序排列")
	public PageBean<OrderResp> queryOrderInfo(@RequestBody OrderReq req){
		return service.queryOrder(req);
	}
	
	/**
	 * 查询订单下商品信息
	 * @param ogk
	 * @return
	 */
	@PostMapping("/query-goods")
	@ApiOperation(value="查询订单下商品信息", notes="分页查询订单下商品信息\r\n当前页、每页展示的条数未传则默认为1和15")
	public PageBean<OrderGoods> queryOrderGoods(@RequestBody OrderGoodsKey ogk){
		if(Objects.isNull(ogk)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "查询订单商品");
			pe.setAddtionalMessage("入参不可为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(ogk.getOrderId())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "查询订单商品");
			pe.setAddtionalMessage("入参订单编号【orderId】不可为空！");
			throw pe;
		}
		return service.queryOrderGoods(ogk);
	}
}
