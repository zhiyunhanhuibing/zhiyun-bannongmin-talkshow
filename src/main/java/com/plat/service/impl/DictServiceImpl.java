package com.plat.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.StringUtil;
import com.plat.bean.Dict;
import com.plat.bean.DictData;
import com.plat.bean.DictType;
import com.plat.bean.OperationDbMessage;
import com.plat.constant.DictErrors;
import com.plat.dao.DictDao;
import com.plat.dao.DictTypeDao;
import com.plat.exception.PlatException;
import com.plat.service.DictService;

/**
 * 字典Service
 * @author CR
 *
 */
@Service
public class DictServiceImpl implements DictService{

	@Autowired
	private DictDao dao;
	
	@Autowired
	private DictTypeDao typeDao;
	
	@Override
	@Transactional
	public OperationDbMessage addDict(Dict di) {   
		OperationDbMessage message = new OperationDbMessage();
		try {
			int addCount = dao.addDict(di);
			if(addCount == 0) {
				throw new PlatException(DictErrors.DICT_ADD_ERROR, "添加字典");
			}
			message.setStatusCode(200);
			message.setStatusMessage("添加字典成功！");
		} catch (Exception e) {
			throw new PlatException(DictErrors.DICT_ADD_ERROR, "添加字典",e);
		}		
		return message;
	}

	@Override
	@Transactional
	public OperationDbMessage delDict(List<String> ids) {
		try {
			int delCount = dao.delDict(ids);
			if(delCount == 0) {
				throw new PlatException(DictErrors.DICT_DEL_ERROR, "删除字典");
			}
			OperationDbMessage message = new OperationDbMessage();
			message.setStatusCode(200);
			message.setStatusMessage("删除字典成功！");
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PlatException(DictErrors.DICT_DEL_ERROR, "删除字典",e);
		}	
	}

	@Override
	@Transactional
	public OperationDbMessage modifyDict(Dict di) {
		try {
			int updateCount = dao.modifyDict(di);
			if(updateCount == 0) {
				throw new PlatException(DictErrors.DICT_UPDATE_ERROR, "修改字典");
			}
			OperationDbMessage message = new OperationDbMessage();
			message.setStatusCode(200);
			message.setStatusMessage("修改字典成功！");
			return message;
		} catch (Exception e) {
			throw new PlatException(DictErrors.DICT_DEL_ERROR, "修改字典",e);
		}	
	}

	@Override
	public List<Dict> queryDict(Dict di) {
		return dao.queryDict(di);
	}

	/**
	 * 查询字典数据
	 */
	@Override
	public List<DictData> queryDictData(String type) {
		List<DictData> li = new ArrayList<>();
		// 查询字典类型相关信息
		DictType dt = typeDao.dictTypeSelectByType(type);
		if(Objects.isNull(dt) || StringUtil.isEmpty(dt.getType())) {
			throw new PlatException(DictErrors.NOTHING_DICT_TYPE, "查询字典数据");
		}
		Dict dict = new Dict();
		dict.setType(dt.getType());
		List<Dict> liDict = dao.queryDict(dict);
		// 不是sql
		if("0".equals(dt.getIsSql())) {
			 if(null!=liDict && liDict.size()>0) {
				 for (Dict d : liDict) {
					DictData dictD = new DictData();
					dictD.setCode(d.getCode());
					dictD.setName(d.getName());
					li.add(dictD);
				}
			 }
		}
		// 是sql
		else {
			String sql = "";
			if(null!=liDict && liDict.size()>0) {
				// 取最新一条记录
				sql = liDict.get(liDict.size()-1).getSql();
			}
			if(StringUtil.isEmpty(sql)) {
				throw new PlatException(DictErrors.DB_DATA_ERROR, "查询字典数据");
			}
			li = dao.queryDictData(sql);
		}
		return li;
	}

}
