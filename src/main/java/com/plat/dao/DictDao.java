package com.plat.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.plat.bean.Dict;
import com.plat.bean.DictData;

/**
 * 字典管理dao
 * @author CR
 *
 */
public interface DictDao {
	/**
	 * 添加字典
	 * @param di
	 * @return
	 */
	public int addDict(Dict di);
	/**
	 * 删除字典
	 * @param di
	 * @return
	 */
	public int delDict(@Param("ids")List<String> ids);
	/**
	 * 修改字典
	 * @param di
	 * @return
	 */
	public int modifyDict(Dict di);
	/**
	 * 查询字典
	 * @param di
	 * @return
	 */
	public List<Dict> queryDict(Dict di);
	
	/**
	 * 查询字典结果集
	 * @param reqMap
	 * @return
	 */
	public List<DictData> queryDictData(@Param("sql") String sql);
}
