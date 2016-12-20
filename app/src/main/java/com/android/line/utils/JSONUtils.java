package com.android.line.utils;

import com.android.line.model.PictureBean;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * 这是一个JSON的工具集 封装了一些常见操作
 * 
 * @author cuimingqiang at 2014年10月6日
 * 
 */
public class JSONUtils {
	/**
	 * 将Map转换成JSON对象
	 * 
	 * @param map
	 * @return
	 */
	public static JSONObject mapToJSON(Map<String, ?> map) {
		JSONObject object = new JSONObject();
		for (Entry<String, ?> entry : map.entrySet()) {
			putMap(object, entry.getKey(), entry.getValue());
		}
		return object;
	}

	/**
	 * 捕捉添加json数据时出现异常，以免导致后面的数据无法添加。
	 * 
	 * @param object
	 * @param key
	 * @param value
	 */
	private static void putMap(JSONObject object, String key, Object value) {
		try {
			object.put(key, value);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 从JSON对象中获取指定字符串
	 * 
	 * @see #getString(JSONObject, String, String)
	 * @param object
	 *            JSON对象
	 * @param key
	 *            键值
	 * @return
	 */
	public static String getString(JSONObject object, String key) {
		return getString(object, key, "");
	}

	/**
	 * @see #getString(JSONObject, String)
	 * @param object
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static String getString(JSONObject object, String key,
			String defValue) {
		String result = null;
		try {
			result = object.getString(key);
		} catch (JSONException e) {
			e.printStackTrace();
			result = defValue;
		}
		return result;
	}

	/**
	 * 获取long类型的数据
	 * 
	 * @see #getLong(JSONObject, String, long)
	 * @param object
	 * @param key
	 * @return
	 */
	public static long getLong(JSONObject object, String key) {
		return getLong(object, key, -1);
	}

	/**
	 * 获取long类型的数据，
	 * 
	 * @see #getLong(JSONObject, String)
	 * @param object
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static long getLong(JSONObject object, String key, long defValue) {
		long result = 0;
		try {
			result = object.getLong(key);
		} catch (JSONException e) {
			e.printStackTrace();
			result = defValue;
		}
		return result;
	}

	/**
	 * 从JSON对象中获取指定数值，
	 * 
	 * @param object
	 *            JSON对象
	 * @param key
	 *            键值
	 * @param defValue
	 *            缺省值
	 * @return
	 */
	public static int getInt(JSONObject object, String key, int defValue) {
		int result = 0;
		try {
			result = object.getInt(key);
		} catch (JSONException e) {
			e.printStackTrace();
			result = defValue;
		}
		return result;
	}

	/**
	 * 从JSON对象中获取指定数值，
	 * 
	 * @param object
	 *            JSON对象
	 * @param key
	 *            键值
	 * @param defValue
	 *            缺省值
	 * @return
	 */
	public static Double getDouble(JSONObject object, String key,
			Double defValue) {
		Double result = 0.0;
		try {
			result = object.getDouble(key);
		} catch (JSONException e) {
			e.printStackTrace();
			result = defValue;
		}
		return result;
	}

	/**
	 * 从JSON对象中获取JSON数组
	 * 
	 * @param object
	 *            JSON对象
	 * @param key
	 *            键值
	 * @return
	 */
	public static JSONArray getJSONArray(JSONObject object, String key) {
		JSONArray array = null;
		try {
			array = object.getJSONArray(key);
		} catch (JSONException e) {
			e.printStackTrace();
			array = null;
		}
		return array;
	}

	/**
	 * 从JSON对象中获取JSON
	 * 
	 * @param object
	 *            JSON对象
	 * @param key
	 *            键值
	 * @return
	 */
	public static JSONObject getJSONPersonBean(JSONObject object, String key) {
		JSONObject array = null;
		try {
			array = object.getJSONObject(key);
		} catch (JSONException e) {
			e.printStackTrace();
			array = null;
		}
		return array;
	}



	public static ArrayList<PictureBean> getPictureBean(JSONObject object,
			String key) {
		JSONArray jsondata = JSONUtils.getJSONArray(object, key);
		ArrayList<PictureBean> list = new ArrayList<PictureBean>();
		try {
			if (jsondata != null) {
				for (int i = 0; i < jsondata.length(); i++) {
					JSONObject object1 = jsondata.getJSONObject(i);
					PictureBean bean = PictureBean.createFromJSON(object1);
					list.add(bean);
				}
			} else {
				list = null;
			}
		} catch (JSONException e) {
			e.printStackTrace();
			list = null;
		}
		return list;
	}



}
