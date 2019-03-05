package com.plat.constant;

import com.plat.exception.ErrorEnumInterface;
import com.plat.exception.ErrorInfo;

import lombok.Getter;

/**
 * 字典异常信息
 * @author Administrator
 *
 */
public enum GoodsTypeErrors  implements ErrorEnumInterface{
	/**
	 * "0300001","添加商品类型出错！"
	 */
    GOODS_TYPE_ADD_ERROR(new ErrorInfo("0300001","添加商品类型出错！")),
	/**
	 * "0300002","删除商品类型出错！"
	 */
    GOODS_TYPE_DEL_ERROR(new ErrorInfo("0300002","删除商品类型出错！")),
    /**
	 * "0300004","商品类型已经存在！"
	 */
    IDENTICAL_GOODS_TYPE_ERROR(new ErrorInfo("0300004","商品类型已经存在！")),
	/**
	 * "0300003","修改商品类型出错！"
	 */
    GOODS_TYPE_UPDATE_ERROR(new ErrorInfo("0300003","修改商品类型出错！")),
    /**
	 * "0300005","查询商品类型出错！"
	 */
    GOODS_TYPE_QUERY_ERROR(new ErrorInfo("0300005","查询商品类型出错！"));
	
	@Getter
	private ErrorInfo errorInfo;
	GoodsTypeErrors(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}
}
