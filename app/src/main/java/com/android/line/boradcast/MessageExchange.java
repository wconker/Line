package com.android.line.boradcast;

import java.util.Map;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

import com.android.line.utils.Constants;
import com.android.line.utils.JSONUtils;

/**
 *
 * 该广播主要用于Activity与Service通信，解析了来自Service的信息,
 * 当从Service收到消息，{@link OnMessageListener #onMessage(int, int, String, Bundle)}将数据传给监听方，
 * <p>封装了一个意图，用于向Service发送消息，
 * <p>需要在Activity中手动调用注册和注销该广播，并且实现{@link OnMessageListener #onMessage(int, int, String, Bundle)}方法。
 * @see #registerReceiver()
 * @see #unregisterReceiver()
 * @author by 崔明强  at 2014年9月18日</p>
 */
public class MessageExchange extends BroadcastReceiver {
	public static final int CMD_DEAFULT = -10000;
	public static final int CODE_DEAFULT = -1;
	private OnMessageListener mListener;
	private Context mContext;
	public MessageExchange(Context context,OnMessageListener onMessageListener){
		mListener = onMessageListener;
		mContext = context;
	}
	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle msg = intent.getExtras();
		int cmd = msg.getInt("cmd", CMD_DEAFULT);
		int code = msg.getInt("code", CODE_DEAFULT);
		String message = msg.getString("message");
		Bundle data = msg.getBundle("data");
		if(mListener!=null){
			
		
			mListener.onMessage(cmd, code, message, data);
		}
	}
	/**
	 * 注册该广播
	 */
	public void registerReceiver(){
		IntentFilter filter = new IntentFilter();
		filter.addAction(Constants.ACTION_RECIVER_MESSAGE);
		LocalBroadcastManager.getInstance(mContext).registerReceiver(this, filter);//本地广播，防止其他程序攻击
		//mContext.registerReceiver(this, filter);
	}
	/**
	 * 封装了广播，向服务端发送消息
	 * @see #sendMessage(Map)
	 * @param msg 将JSON数据转换成字符串
	 */
	public void sendMessage(String msg){
		Intent intent = new Intent();
		intent.setAction(Constants.ACTION_SEND_MESSAGE);
		intent.putExtra("msg", msg);
        Log.e("wkh","发送广播数据"+msg);
		//mContext.sendBroadcast(intent);
		LocalBroadcastManager.getInstance(mContext).sendBroadcast(intent);
	}
	/**
	 * @see #sendMessage(String)
	 * @param map 封装了数据字段
	 */
	public void sendMessage(Map<String, ?> map){


		sendMessage(JSONUtils.mapToJSON(map).toString());
	}
	/**
	 * 注销广播
	 */
	public void unregisterReceiver(){
		try {
			//mContext.unregisterReceiver(this);
			LocalBroadcastManager.getInstance(mContext).unregisterReceiver(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 服务端消息对外借口
	 * Constants 这里封装了所以命令
	 * @author by 崔明强  at 2014年9月18日
	 *
	 */
	public interface OnMessageListener{
		/**
		 * 当收到服务端消息
		 * @param cmd 命令
		 * @param code 
		 * @param message
		 * @param data 携带的额外数据
		 */
		void onMessage(int cmd, int code, String message, Bundle data);
	}
}
