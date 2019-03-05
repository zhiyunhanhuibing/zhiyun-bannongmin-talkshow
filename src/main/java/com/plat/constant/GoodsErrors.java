package com.plat.constant;

import com.plat.exception.ErrorEnumInterface;
import com.plat.exception.ErrorInfo;

import lombok.Getter;

/**
 * 商品异常信息
 * @author Administrator
 *
 */
public enum GoodsErrors  implements ErrorEnumInterface{
	/**
	 * "0100001","添加商品信息出错！"
	 */
    GOODS_ADD_ERROR(new ErrorInfo("0300001","添加商品信息出错！")),
	/**
	 * "0100002","修改商品信息出错！"
	 */
    GOODS_DEL_ERROR(new ErrorInfo("0300002","删除商品信息出错！")),
	/**
	 * "0100002","修改商品信息出错！"
	 */
    GOODS_UPDATE_ERROR(new ErrorInfo("0300003","删除商品信息出错！"));
	
	@Getter
	private ErrorInfo errorInfo;
	GoodsErrors(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}
}
