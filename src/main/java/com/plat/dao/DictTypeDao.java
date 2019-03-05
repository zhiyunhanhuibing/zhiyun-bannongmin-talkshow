package com.plat.dao;

import java.util.List;
import com.plat.bean.DictType;

public interface DictTypeDao {
	public int dictTypeSave(DictType dictType) ;

	public List<DictType> dictTypeSelectAll();

	public int dictTypeDelete(String type);

	public DictType dictTypeSelectByType(String type);

	public int dictTypeUpdateOne(DictType dictType);
	

}
