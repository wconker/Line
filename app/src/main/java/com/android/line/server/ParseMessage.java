package com.android.line.server;


import static com.android.line.utils.Constants.CMD_LOGIN;


import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;


import com.android.line.model.PersonBean;
import com.android.line.model.User;
import com.android.line.utils.Constants;
import com.android.line.utils.JSONUtils;
import com.android.line.utils.SharedPreferencesUtils;

/**
 * 解析来自网络、客户端的消息
 * 
 * @author by 崔明强 at 2014年9月25日
 * 
 */
public class ParseMessage {
	private static final String TAG = "ParseMessage";

	public static int parse(String msg, Bundle outMessage, Context context)
			throws JSONException {
		JSONObject object = new JSONObject(msg);
		String strCmd = JSONUtils.getString(object, "cmd", "client");
		int code = JSONUtils.getInt(object, "code", -1);
		String message = JSONUtils.getString(object, "message", "未知错误");
		int cmd = toInt(strCmd);// 将字符串命令转换成Int类型
		outMessage.putInt("cmd", cmd);
		outMessage.putInt("code", code);
		outMessage.putString("message", message);
		JSONArray jsondata = JSONUtils.getJSONArray(object, "data");
		Bundle data = new Bundle();
		try {
			switch (cmd) {
			case CMD_LOGIN:
				if (code == 0) {
					loginData(jsondata,outMessage);
				}
				break;


			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		outMessage.putBundle("data", data);
		return cmd;
	}

	//
	/**
	 * 把字符串转成int类型的命令
	 * 
	 * @param cmd
	 * @return
	 */
	public static int toInt(String cmd) {
		int result = 0;
		switch (cmd) {
		case "Comm.User.login":
			result = CMD_LOGIN;
			break;

		default:
			break;
		}
		return result;
	}

	/**
	 * 解析登录返回的数据
	 *
	 * @param array
	 * @param bundle
	 * @throws JSONException
	 */
	private static void loginData(JSONArray array, Bundle bundle)
			throws JSONException {
		if (array == null) {
			throw new RuntimeException("loginData中Data不能为NULL！");
		}
		JSONObject object = array.getJSONObject(0);
		User user = User.createFromJSON(object);
		bundle.putParcelable("data", user);
	}


}
