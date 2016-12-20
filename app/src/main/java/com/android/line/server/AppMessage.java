package com.android.line.server;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;

import com.android.line.utils.JSONUtils;

import static com.android.line.utils.Constants.*;
/**
 * 客户端错误消息
 * 模拟服务端消息格式，
 * @author cuimingqiang at 2014年10月6日
 *
 */
public class AppMessage {

	public static String clientError(Map<String, Object> map){
		map.put("cmd", "client");
		map.put("data", new JSONArray());
		return JSONUtils.mapToJSON(map).toString();
	}
	/**
	 * 网络未连接消息，
	 * @return
	 */
	public static String websocketNotConnected(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("code", WebSocket_NotConnected);
		map.put("message", "服务器未连接或已断开");
		return clientError(map);
	}
	/**
	 * 网络关闭消息
	 * @return
	 */
	public static String websocketOnClose(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("code", WebSocket_OnClose);
		map.put("message", "连接服务器已关闭，正在尝试重新连接");
		return clientError(map);
	}
	/**
	 * 网络错误消息
	 * @return
	 */
	public static String websocketOnError(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("code", WebSocket_OnError);
		map.put("message", "连接服务器错误");
		return clientError(map);
	}
	/**
	 * 网络连接成功消息
	 * @return
	 */
	public static String websocketOnOpen(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("code", WebSocket_OnOpen);
		map.put("message", "服务器已连接");
		return clientError(map);
	}
}
