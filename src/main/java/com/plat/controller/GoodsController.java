package com.plat.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.StringUtil;
import com.plat.bean.Goods;
import com.plat.bean.GoodsKey;
import com.plat.bean.GoodsReq;
import com.plat.bean.GoodsReqBean;
import com.plat.bean.OperationDbMessage;
import com.plat.config.PageBean;
import com.plat.constant.CommonErrors;
import com.plat.exception.PlatException;
import com.plat.service.GoodsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/goods")
@Api(value="商品管理", tags="商品管理控制器")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ApiOperation(value="增加商品信息", notes="增加商品信息接口\r\n商品类型为必传字段\r\n商品编号后台生成、创建时间、修改时间、创建人、修改人后台自动获取")
	public OperationDbMessage goodsSave(@RequestBody GoodsReqBean goods) {
		if(Objects.isNull(goods)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "增加商品信息");
			pe.setAddtionalMessage("入参不可为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(goods.getType())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "增加商品信息");
			pe.setAddtionalMessage("入参商品类型【type】不可为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(goods.getGoodsName())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "增加商品信息");
			pe.setAddtionalMessage("入参商品名称【goodsName】不可为空！");
			throw pe;
		}
		if(goods.getOriginalPrice()<=0) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "增加商品信息");
			pe.setAddtionalMessage("入参商品售价【originalPrice】必须大于0！");
			throw pe;
		}
		return goodsService.goodsSave(goods);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ApiOperation(value="删除商品信息", notes="删除商品信息接口\r\n通过商品类型编码以及商品编号删除商品")
	public OperationDbMessage goodsDelete(@RequestBody GoodsKey goods) {
		if(Objects.isNull(goods)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "删除商品信息");
			pe.setAddtionalMessage("入参不可为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(goods.getType())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "删除商品信息");
			pe.setAddtionalMessage("入参商品类型【type】不可为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(goods.getGoodsId())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "删除商品信息");
			pe.setAddtionalMessage("入参商品编号【goodsId】不可为空！");
			throw pe;
		}
		return goodsService.goodsDelete(goods);
	}
	
	@RequestMapping(value = "/select-type", method = RequestMethod.POST)
	@ApiOperation(value="查询商品信息", notes="查询商品信息接口\r\n查询各商品类型下的商品信息\r\n前台分页展示")
	public PageBean<Goods> goodsSelectByType(@RequestBody GoodsReq goods) {
		if(Objects.isNull(goods)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "查询商品信息");
			pe.setAddtionalMessage("入参不可为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(goods.getType())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "查询商品信息");
			pe.setAddtionalMessage("入参商品类型【type】不可为空！");
			throw pe;
		}
		return goodsService.goodsSelectByType(goods);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@ApiOperation(value="修改商品信息", notes="修改商品信息接口\r\n按照商品类型编码和商品类型修改商品信息\r\n商品类型不可修改，商品编码不可修改")
	public OperationDbMessage goodsUpdateOne(@RequestBody GoodsReqBean goods) {
		if(Objects.isNull(goods)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改商品信息");
			pe.setAddtionalMessage("入参不可为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(goods.getType())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改商品信息");
			pe.setAddtionalMessage("入参商品类型【type】不可为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(goods.getGoodsId())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改商品信息");
			pe.setAddtionalMessage("入参商品编号【goodsId】不可为空！");
			throw pe;
		}
		return goodsService.goodsUpdateOne(goods);
	}
}
