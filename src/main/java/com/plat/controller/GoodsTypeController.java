package com.plat.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.StringUtil;
import com.plat.bean.GoodsType;
import com.plat.bean.OperationDbMessage;
import com.plat.bean.Tree;
import com.plat.constant.CommonErrors;
import com.plat.exception.PlatException;
import com.plat.service.GoodsTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 商品类型类
 * @author CR
 *
 */
@RestController
@RequestMapping("/goods-type")
@Api(value="商品类型", tags="商品类型接口")
public class GoodsTypeController {
	@Autowired
	private GoodsTypeService service;
	
	@PostMapping("/add")
	@ApiOperation(value="添加商品类型", notes="添加商品类型")
	public OperationDbMessage addGoodsType(@RequestBody GoodsType gt) {
		if(Objects.isNull(gt)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "增加商品类型");
			pe.setAddtionalMessage("入参不可为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(gt.getType())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "增加商品类型");
			pe.setAddtionalMessage("入参商品类型编码【type】不可为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(gt.getTypeName())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "增加商品类型");
			pe.setAddtionalMessage("入参商品类型中文名【typeName】不可为空！");
			throw pe;
		}
		return service.addGoodsType(gt);
	}
	
	@PostMapping("/del")
	@ApiOperation(value="删除商品类型", notes="删除商品类型\r\n删除商品类型需要保证商品类型下无商品")
	public OperationDbMessage delGoodsType(@RequestBody List<String> ids) {
		if(Objects.isNull(ids)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "删除商品类型");
			pe.setAddtionalMessage("入参不可为空！");
			throw pe;
		}
		return service.delGoodsType(ids);
	}
	
	@PostMapping("/modify")
	@ApiOperation(value="修改商品类型", notes="修改商品类型\r\n只可修改商品类型名称和描述，不可修改商品类型编码")
	public OperationDbMessage modifyGoodsType(@RequestBody GoodsType gt) {
		if(Objects.isNull(gt)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改商品类型");
			pe.setAddtionalMessage("入参不可为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(gt.getId())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改商品类型");
			pe.setAddtionalMessage("入参商品类型编号【id】不可为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(gt.getType())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改商品类型");
			pe.setAddtionalMessage("入参商品类型编码【type】不可为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(gt.getTypeName())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改商品类型");
			pe.setAddtionalMessage("入参商品类型中文名【typeName】不可为空！");
			throw pe;
		}
		return service.modifyGoodsType(gt);
	}
	
	@PostMapping("/query")
	@ApiOperation(value="查询商品类型", notes="查询商品类型\r\n查询的商品类型树形结构")
	public List<Tree> queryGoodsType(){
		return service.queryGoodsType("");
	}
}
