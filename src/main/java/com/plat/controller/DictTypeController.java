package com.plat.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.plat.bean.DictType;
import com.plat.bean.OperationDbMessage;
import com.plat.service.DictTypeService;

@RestController
@RequestMapping("/dict-type")
public class DictTypeController {
	@Autowired
	private DictTypeService dictTypeService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public OperationDbMessage dictTypeSave(@RequestBody DictType dictType) {
		return dictTypeService.dictTypeSave(dictType);
	}
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public List<DictType> dictTypeSelectAll() {
		return dictTypeService.dictTypeSelectAll();
	}
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public OperationDbMessage dictTypeDelete(@RequestBody DictType dictType) {
		return dictTypeService.dictTypeDelete(dictType.getType());
	}
	@RequestMapping(value = "/select-type", method = RequestMethod.POST)
	public DictType dictTypeSelectByType(@RequestBody DictType dictType) {
		return dictTypeService.dictTypeSelectByType(dictType.getType());
	}
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public OperationDbMessage dictTypeUpdateOne(@RequestBody DictType dictType) {
		return dictTypeService.dictTypeUpdateOne(dictType);
	}
	
}
