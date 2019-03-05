package com.plat.service;

import java.util.List;

import com.plat.bean.Dict;
import com.plat.bean.DictData;
import com.plat.bean.OperationDbMessage;

public interface DictService {
	/**
	 * 添加字典
	 * @param di
	 * @return
	 */
	public OperationDbMessage addDict(Dict di);
	/**
	 * 删除字典
	 * @param di
	 * @return
	 */
	public OperationDbMessage delDict(List<String> ids);
	/**
	 * 修改字典
	 * @param di
	 * @return
	 */
	public OperationDbMessage modifyDict(Dict di);
	/**
	 * 查询字典
	 * @param di
	 * @return
	 */
	public List<Dict> queryDict(Dict di);
	
	/**
	 * 查询字典配置sql对应的字典数据
	 * @param sql
	 * @return
	 */
	public List<DictData> queryDictData(String type);
}
