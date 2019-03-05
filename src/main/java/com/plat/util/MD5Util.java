package com.plat.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.plat.constant.UtilErrors;
import com.plat.exception.PlatException;

/**
 * MD5辅助类
 * @author chenrong
 *
 */
public class MD5Util {
	/**
	 * MD5加密基础用法类
	 * @param str 待加密串
	 * @return
	 */
	public static String getMD5(String str) {
		String md5Str = "";
		try {
			// 生成一个MD5加密计算摘要
			 MessageDigest md = MessageDigest.getInstance("MD5");
			 // 计算md5函数
			 md.update(str.getBytes());
			 // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
			 // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
			md5Str =  new BigInteger(1, md.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			throw new PlatException(UtilErrors.MD5_ERROR);
		}
		return md5Str;
	}
}
