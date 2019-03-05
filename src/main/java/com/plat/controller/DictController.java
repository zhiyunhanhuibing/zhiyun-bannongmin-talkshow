package com.plat.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.StringUtil;
import com.plat.bean.Dict;
import com.plat.bean.DictData;
import com.plat.bean.OperationDbMessage;
import com.plat.constant.CommonErrors;
import com.plat.exception.PlatException;
import com.plat.service.DictService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 字典接口类
 * @author CR
 *
 */
@RestController
@RequestMapping("/dict")
@Api(value="/dict", tags="字典配置")
public class DictController {
	@Autowired
	private DictService service;
	@ApiOperation(value="添加字典数据", notes = "添加字典数据")
	@PostMapping("/add")
	public OperationDbMessage addDict(@RequestBody Dict di) {
		if(Objects.isNull(di)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "添加字典");
			pe.setAddtionalMessage("入参有误！");
			throw pe;
		}
		if(StringUtil.isEmpty(di.getType())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "添加字典");
			pe.setAddtionalMessage("入参字典类型【type】不能为空！");
			throw pe;
		}
		return service.addDict(di);
	}

	@ApiOperation(value="删除字典数据", notes = "删除字典数据")
	@PostMapping("/del")
	public OperationDbMessage delDict(@RequestBody List<String> ids) {
		if(Objects.isNull(ids)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "删除字典");
			pe.setAddtionalMessage("入参有误！");
			throw pe;
		}
		return service.delDict(ids);
	}
	
	@ApiOperation(value="修改字典数据", notes = "修改字典数据")
	@PostMapping("/modify")
	public OperationDbMessage modifyDict(@RequestBody Dict di) {
		if(Objects.isNull(di)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改字典");
			pe.setAddtionalMessage("入参有误！");
			throw pe;
		}
		if(StringUtil.isEmpty(di.getType())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改字典");
			pe.setAddtionalMessage("入参字典数值主键【id】不能为空！");
			throw pe;
		}
		return service.modifyDict(di);
	}	

	@ApiOperation(value="查询字典数据", notes = "查询字典数据")
	@PostMapping("/query")
	public List<Dict> queryDict(@RequestBody Dict di){
		if(Objects.isNull(di)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "查询字典");
			pe.setAddtionalMessage("入参有误！");
			throw pe;
		}
		if(StringUtil.isEmpty(di.getType())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "查询字典");
			pe.setAddtionalMessage("入参字典类型【type】不能为空！");
			throw pe;
		}
		return service.queryDict(di);
	}
	
	@GetMapping("/get-data/{type}")
	@ApiOperation(value="查询字典详细数据", notes="查询字典详细数据接口\r\n字典类型编码为必传参数")
	public List<DictData> queryDictData(@PathVariable("type") String type){
		if(StringUtil.isEmpty(type)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "查询字典详细数据");
			pe.setAddtionalMessage("入参字典类型【type】不能为空！");
			throw pe;
		}
		return service.queryDictData(type);
	}
}
