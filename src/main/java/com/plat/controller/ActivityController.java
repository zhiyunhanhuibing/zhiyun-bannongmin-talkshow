package com.plat.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.StringUtil;
import com.plat.bean.Activity;
import com.plat.bean.ActivityGoods;
import com.plat.bean.ActivityPriKey;
import com.plat.bean.ActivityResp;
import com.plat.bean.Goods;
import com.plat.bean.GoodsReq;
import com.plat.bean.OperationDbMessage;
import com.plat.config.PageBean;
import com.plat.constant.CommonErrors;
import com.plat.exception.PlatException;
import com.plat.service.ActivityService;
import com.plat.service.GoodsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 活动信息相关管理控制器
 * @author CR
 *
 */
@RestController
@RequestMapping("/activity")
@Api(value="活动管理", tags="活动信息相关管理控制器")
public class ActivityController {
	@Autowired
	ActivityService service;
	
	@Autowired
	GoodsService goodsService;
	
	@PostMapping("/add")
	@ApiOperation(value="保存活动信息", notes="保存活动信息接口\r\n活动类型、活动名称、活动附件信息为必传参数")
	public OperationDbMessage addActivityInfo(@RequestBody Activity ac) {
		if(Objects.isNull(ac)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "保存活动信息");
			pe.setAddtionalMessage("入参有误！");
			throw pe;
		}
		if(StringUtil.isEmpty(ac.getActiviType())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "保存活动信息");
			pe.setAddtionalMessage("入参活动类型【activiType】不能为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(ac.getActivityName())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "保存活动信息");
			pe.setAddtionalMessage("入参活动名称【activityName】不能为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(ac.getFileName())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "保存活动信息");
			pe.setAddtionalMessage("入参文件名称【fileName】不能为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(ac.getFileOriginalName())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "保存活动信息");
			pe.setAddtionalMessage("入参文件原名【fileOriginalName】不能为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(ac.getFilePath())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "保存活动信息");
			pe.setAddtionalMessage("入参文件地址【filePath】不能为空！");
			throw pe;
		}
		return service.addActivity(ac);
	}
	
	@PostMapping("/modify")
	@ApiOperation(value="修改活动信息", notes="修改活动信息接口\r\n活动编号、活动类型、活动名称、活动附件信息为必传参数")
	public OperationDbMessage modifyActivityInfo(@RequestBody Activity ac) {
		if(Objects.isNull(ac)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改活动信息");
			pe.setAddtionalMessage("入参有误！");
			throw pe;
		}
		if(StringUtil.isEmpty(ac.getId())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改活动信息");
			pe.setAddtionalMessage("入参活动编号【id】不能为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(ac.getActiviType())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改活动信息");
			pe.setAddtionalMessage("入参活动类型【activiType】不能为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(ac.getActivityName())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改活动信息");
			pe.setAddtionalMessage("入参活动名称【activityName】不能为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(ac.getFileName())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改活动信息");
			pe.setAddtionalMessage("入参文件名称【fileName】不能为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(ac.getFileOriginalName())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改活动信息");
			pe.setAddtionalMessage("入参文件原名【fileOriginalName】不能为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(ac.getFilePath())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "保存活动信息");
			pe.setAddtionalMessage("入参文件地址【filePath】不能为空！");
			throw pe;
		}
		return service.modifyActivity(ac);
	}
	
	@PostMapping("/query")
	@ApiOperation(value="查询活动信息", notes="查询活动信息接口\r\n单条查询\r\n活动编号、活动类型编码为必传参数")
	public ActivityResp queryActivityInfo(@RequestBody ActivityPriKey acKey) {
		if(Objects.isNull(acKey)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "查询活动信息");
			pe.setAddtionalMessage("入参有误！");
			throw pe;
		}
		if(StringUtil.isEmpty(acKey.getActiviType())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "查询活动信息");
			pe.setAddtionalMessage("入参活动类型【activiType】不能为空！");
			throw pe;
		}
		return service.queryActivity(acKey);
	}
	
	@PostMapping(value = "/query-goods")
	@ApiOperation(value="查询商品信息", notes="查询商品信息接口\r\n查询所有未参与活动的商品\r\n前台分页展示")
	public PageBean<Goods> goodsSelectByType(@RequestBody GoodsReq goods) {
		if(Objects.isNull(goods)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "查询商品信息");
			pe.setAddtionalMessage("入参不可为空！");
			throw pe;
		}
		// 此处查询所有
		// 不包含有折扣价和其他活动的
		goods.setType("all");
		return goodsService.goodsSelectByType(goods);
	}
	
	@PostMapping(value = "/activity-goods")
	@ApiOperation(value="关联活动到商品", notes="关联活动到商品接口\r\n入参活动类型编码、商品编号集合不可为空")
	public OperationDbMessage addActivityToGoods(@RequestBody ActivityGoods ag) {
		if(Objects.isNull(ag)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "关联活动至商品");
			pe.setAddtionalMessage("入参不可为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(ag.getActivityType())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "关联活动至商品");
			pe.setAddtionalMessage("入参活动类型【activityType】不可为空！");
			throw pe;
		}
		if(Objects.isNull(ag.getGoodsIds()) || ag.getGoodsIds().size()==0) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "关联活动至商品");
			pe.setAddtionalMessage("入参商品编号集合【goodsIds】不可为空！");
			throw pe;
		}
		return service.addActivityToGoogs(ag);
	}
}
