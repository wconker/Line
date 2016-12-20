package com.android.line.utils;

import android.text.TextUtils;
/**
 * 字符串帮助类，
 * 封装了一些操作，
 * 注意用于过滤输入的字符串，
 * 在发布记录等功能中有用到
 * @author cuimingqiang at 2014年10月6日
 *
 */
public class StringUtils {
	/**
	 * 检查String是否为null,如果为null,返回一个指定的缺省值
	 * @param value 要检查的String
	 * @param defValue 缺省值
	 * @return
	 */
	public static String getString(String value,String defValue){
		return value==null?defValue:value.trim();
	}
	/**
	 * 检查String是否为null,
	 * @see #getString(String, String)
	 * @param value
	 * @return
	 */
	public static String getString(String value){
		return getString(value, "");
	}
	/**
	 * 判断String 是否为null或空
	 * @param value
	 * @return
	 */
	public static Boolean checkStringIsEmpty(String value){
		if(value==null||TextUtils.isEmpty(value)){
			return true;
		}
		return false;
	}
}
