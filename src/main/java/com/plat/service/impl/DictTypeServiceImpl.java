package com.plat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plat.bean.DictType;
import com.plat.constant.DictErrors;
import com.plat.constant.DictTypeErrors;
import com.plat.bean.OperationDbMessage;
import com.plat.dao.DictTypeDao;
import com.plat.exception.PlatException;
import com.plat.service.DictTypeService;

/**
 * 
 * @author jm
 *
 */
@Service
public class DictTypeServiceImpl implements DictTypeService {
	@Autowired
	private DictTypeDao dictTypeDao;

	@Override
	@Transactional
	public OperationDbMessage dictTypeSave(DictType dictType) {
		OperationDbMessage message = new OperationDbMessage();
		try {
			int addCount = dictTypeDao.dictTypeSave(dictType);
			if (addCount == 0) {
				throw new PlatException(DictErrors.DICT_ADD_ERROR, "添加字典类型");
			}
			message.setStatusCode(200);
			message.setStatusMessage("添加字典类型成功！");
		} catch (Exception e) {
			throw new PlatException(DictErrors.DICT_ADD_ERROR, "添加字典类型", e);
		}
		return message;
	}

	@Override
	public List<DictType> dictTypeSelectAll() {
		return dictTypeDao.dictTypeSelectAll();
	}

	@Override
	@Transactional
	public OperationDbMessage dictTypeDelete(String type) {
		try {
			int delCount = dictTypeDao.dictTypeDelete(type);
			if (delCount == 0) {
				throw new PlatException(DictTypeErrors.DICT_TYPE_DEL_ERROR, "删除字典类型");
			}
			OperationDbMessage message = new OperationDbMessage();
			message.setStatusCode(200);
			message.setStatusMessage("删除字典类型成功！");
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PlatException(DictTypeErrors.DICT_TYPE_DEL_ERROR, "删除字典类型", e);
		}
	}

	@Override
	public DictType dictTypeSelectByType(String type) {
		return dictTypeDao.dictTypeSelectByType(type);
	}

	@Override
	@Transactional
	public OperationDbMessage dictTypeUpdateOne(DictType dictType) {
		try {
			int updateCount = dictTypeDao.dictTypeUpdateOne(dictType);
			if (updateCount == 0) {
				throw new PlatException(DictTypeErrors.DICT_TYPE_UPDATE_ERROR, "修改字典类型");
			}
			OperationDbMessage message = new OperationDbMessage();
			message.setStatusCode(200);
			message.setStatusMessage("修改字典类型成功！");
			return message;
		} catch (Exception e) {
			throw new PlatException(DictTypeErrors.DICT_TYPE_DEL_ERROR, "修改字典类型", e);
		}
	}

}
