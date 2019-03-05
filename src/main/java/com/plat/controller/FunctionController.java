package com.plat.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.StringUtil;
import com.plat.bean.Function;
import com.plat.bean.FunctionKey;
import com.plat.bean.FunctionTree;
import com.plat.bean.OperationDbMessage;
import com.plat.constant.CommonErrors;
import com.plat.exception.PlatException;
import com.plat.service.FunctionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 功能管理控制器
 * @author CR
 *
 */
@RestController
@RequestMapping("/function")
@Api(value="功能管理", tags="功能管理控制器")
public class FunctionController {
	@Autowired
	private FunctionService service;
	/**
	 * 添加功能
	 * @param fun
	 * @return
	 */
	@PostMapping("/add")
	@ApiOperation(value="添加功能信息", notes="添加功能信息接口\r\n功能编码、功能名称不可为空")
	public OperationDbMessage addFunction(@RequestBody Function fun) {
		if(Objects.isNull(fun)) {
			PlatException  pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "添加功能");
			pe.setAddtionalMessage("入参不可为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(fun.getCode())) {
			PlatException  pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "添加功能");
			pe.setAddtionalMessage("入参功能编码【code】不可为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(fun.getName())) {
			PlatException  pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "添加功能");
			pe.setAddtionalMessage("入参功能名称【name】不可为空！");
			throw pe;
		}
		return service.addFunction(fun);
	}
	/**
	 * 修改功能
	 * @param fun
	 * @return
	 */
	@PostMapping("/modify")
	@ApiOperation(value="修改功能信息", notes="修改功能信息接口\r\n主键ID、功能编码、功能名称不可为空")
	public OperationDbMessage modifyFunction(@RequestBody Function fun) {
		if(Objects.isNull(fun)) {
			PlatException  pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改功能");
			pe.setAddtionalMessage("入参不可为空！");
			throw pe;
		}
		if(fun.getId() == 0) {
			PlatException  pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改功能");
			pe.setAddtionalMessage("入参功能主键【id】不可为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(fun.getCode())) {
			PlatException  pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改功能");
			pe.setAddtionalMessage("入参功能编码【code】不可为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(fun.getName())) {
			PlatException  pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改功能");
			pe.setAddtionalMessage("入参功能名称【name】不可为空！");
			throw pe;
		}
		return service.modifyFunction(fun);
	}
	
    /**
     *  删除功能
     * @param funKey
     * @return
     */
	@PostMapping("/del")
	@ApiOperation(value="删除功能信息", notes="删除功能信息接口\r\n主键ID不可为空")
	public OperationDbMessage delFunction(@RequestBody FunctionKey funKey) {
		if(Objects.isNull(funKey)) {
			PlatException  pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "删除功能");
			pe.setAddtionalMessage("入参不可为空！");
			throw pe;
		}
		if(funKey.getId() == 0) {
			PlatException  pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "修改功能");
			pe.setAddtionalMessage("入参功能主键【id】不可为空！");
			throw pe;
		}
		return service.delFunction(funKey);
	}
	
	/**
	 * 查询功能
	 * @return
	 */
	@PostMapping("/query-tree")
	@ApiOperation(value="查询功能信息", notes="查询功能信息接口\r\n树形结构")
	public List<FunctionTree> queryFunction(){
		return service.queryFunction(null);
	}
	/**
	 * 角色授权
	 * @param rid
	 * @param fids
	 * @return
	 */
	@PostMapping("/rel-role-function")
	@ApiOperation(value="角色授权", notes="角色授权接口\r\n角色编号、功能编号数组不可为空")
	public OperationDbMessage relRoleFunction(@RequestParam("rid") int rid, @RequestParam("fids") List<Integer> fids) {
		if(rid == 0) {
			PlatException  pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "关联角色-功能");
			pe.setAddtionalMessage("入参角色编号【rid】不可为空！");
			throw pe;
		}
		if(Objects.isNull(fids) || fids.size() == 0) {
			PlatException  pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "关联角色-功能");
			pe.setAddtionalMessage("赋予角色的功能编号【fids】不可为空！");
			throw pe;
		}
		return service.relRoleFunction(rid, fids);
	}
	/**
	 * 查询已经给角色授权的功能
	 * @param rid
	 * @return
	 */
	@GetMapping("/query-role-function/{rid}")
	@ApiOperation(value="查询已经授权的角色-功能", notes="查询已经授权的角色-功能接口")
	public List<Integer> queryRoleFunction(@PathVariable("rid")Integer rid){
		if(rid == 0) {
			PlatException  pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "查询角色-功能");
			pe.setAddtionalMessage("入参角色编号【rid】不可为空！");
			throw pe;
		}
		List<Integer> liRids = new ArrayList<>();
		liRids.add(rid);
		return service.queryRoleFunction(liRids);
	}
}
