package com.plat.service;

import java.util.List;

import com.plat.bean.DictType;
import com.plat.bean.OperationDbMessage;


public interface DictTypeService {
	public OperationDbMessage dictTypeSave(DictType dictType) ;
	
	public List<DictType> dictTypeSelectAll();

	public OperationDbMessage dictTypeDelete(String type);

	public DictType dictTypeSelectByType(String type);

	public OperationDbMessage dictTypeUpdateOne(DictType dictType);
}
