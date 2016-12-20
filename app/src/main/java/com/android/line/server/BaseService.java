package com.android.line.server;



import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;
import static com.android.line.utils.Constants.CMD_LOGIN;
import com.android.line.R;
import com.android.line.activity.AppLiction;
import com.android.line.model.PersonBean;
import com.android.line.utils.Constants;
import com.android.line.utils.MCrypt;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * 该类是与服务端通信基类，不该被停止。 向服务端发送数据的两个方式： </p> 1，通过广播向服务端发送数据 @see #mSendMessage
 * onReceive 一般命令使用这种方式 </p> 2，通过信使想服务端发送数据 @see #handleMessage BS_SEND_DATA
 * 找货功能使用这种方式</p> 但本质都是调用WebSocket的send()方法。 </p> 分发消息也有两种方式： </p> 1,通过广播 @see
 * sendByBroadcast(Bundlebundle) 用于分发一般普通消息 </p> 2,通过信使 @see
 * sendByMessager(Bundle bundle) 主要用于找货功能中，
 * <p>
 * 该类还实现了定位功能，当接受服务端命令后，启动定位，将经纬度，位置信息上传服务器。
 * 
 * @author by 崔明强 at 2014年9月18日
 */
public class BaseService extends Service implements HBWebSocket.OnMessage {
	private static final String TAG = "BaseService";
	private ExecutorService mExecutors;
	private String ip = "";
	public static String cityname = "请输入始发地";
	public static String address = "当前定位";
	public static String getErrorInfo = "定位失败";
	MCrypt mCrypt = new MCrypt();
	private BroadcastReceiver mSendMessage = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			String msg = intent.getStringExtra("msg");

			Log.e("wkh","服务接受广播");
			/**
			 * 通过广播向服务端发送数据
			 */
			try {
				mWebSocket.send(msg);
				//mWebSocket.send(mCrypt.encrypt(msg));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	};
	public static final int BS_ON_BIND = 1;
	public static final int BS_ON_DATA = 2;
	public static final int BS_SEND_DATA = 3;
	@SuppressLint("HandlerLeak")
	private Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case BS_ON_BIND:
				Log.i(TAG, "mClient-->bind");
				mClient = msg.replyTo;
				break;
			case BS_SEND_DATA:
				/**
				 * 通过信使向服务端发送数据
				 */
				String cmd = (String) msg.obj;
				mWebSocket.send(cmd);
			default:
				break;
			}
		};
	};
	/**
	 * 服务端信使，接收来自客户端的消息。
	 */
	private Messenger mServer = new Messenger(mHandler);
	/**
	 * 客户端信使的引用，用于向服务端发送消息。
	 */
	private Messenger mClient = null;

	@Override
	public IBinder onBind(Intent intent) {
		return mServer.getBinder();
	}

	/**
	 * 负责与服务端通信
	 */
	private HBWebSocket mWebSocket;

	@Override
	public void onCreate() {
		super.onCreate();
//		GetUrl("");
		ip = "ws://180.153.88.58:8156";
		InItData(ip);
		notificationManager = (NotificationManager) this
				.getSystemService(Context.NOTIFICATION_SERVICE);
		AudioManager audioManager = (AudioManager) this
				.getSystemService(Context.AUDIO_SERVICE);
		notification = new Notification(R.drawable.ic_launcher, "专线",
				System.currentTimeMillis());
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		notification.flags |= Notification.FLAG_SHOW_LIGHTS;
		switch (audioManager.getRingerMode()) {
		case AudioManager.RINGER_MODE_SILENT:// 静音模式，值为0，这时候不震动，不响铃
			notification.defaults = Notification.DEFAULT_LIGHTS;
			break;
		case AudioManager.RINGER_MODE_VIBRATE:// 震动模式，值为1，这时候震动，不响铃
			notification.defaults = Notification.DEFAULT_LIGHTS
					| Notification.DEFAULT_VIBRATE;
			break;
		case AudioManager.RINGER_MODE_NORMAL:// 常规模式，值为2，分两种情况：1_响铃但不震动，2_响铃+震动
			notification.defaults = Notification.DEFAULT_LIGHTS
					| Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE;
			break;
		default:
			break;
		}
		notification.ledARGB = Color.BLUE;
		notification.ledOnMS = 5000;
	};

	public void InItData(String url) {

		mExecutors = Executors.newFixedThreadPool(3);
		Log.i(TAG, "NoNull:" + mExecutors==null?"空":"不为空");
		mWebSocket = new HBWebSocket(BaseService.this, url);
		IntentFilter filter = new IntentFilter();
		filter.addAction(Constants.ACTION_SEND_MESSAGE);
		LocalBroadcastManager.getInstance(this).registerReceiver(mSendMessage,
				filter);

	}

	private void GetUrl(String url) {

		StringRequest request = new StringRequest(Method.POST, url,
				new Listener<String>() {

					@Override
					public void onResponse(String arg0) {
						try {
							String success = new String(mCrypt.decrypt(arg0));
							// String success = new String(arg0);
							JSONObject object = new JSONObject(success);
							int code = object.getInt("code");
							if (code == 0) {
								JSONObject data = (JSONObject) (new JSONArray(
										object.getString("data")).get(0));
								ip = data.getString("wsurl");
								Log.e("wkh", "ip:" + ip);
								// ip = "ws://222.185.194.162:8002";
								// ip = "ws://180.153.88.58:7002";
								InItData(ip);
							} else {
								ip = "ws://180.153.88.58:8156";
								InItData(ip);
								Toast.makeText(getBaseContext(), "请求连接失败！",
										Toast.LENGTH_SHORT).show();
							}

						} catch (JSONException e) {
							ip = "ws://180.153.88.58:8156";
							InItData(ip);
							Toast.makeText(getBaseContext(), "请求连接失败！",
									Toast.LENGTH_SHORT).show();
							e.printStackTrace();
						} catch (Exception e) {
							ip = "ws://180.153.88.58:8156";
							InItData(ip);
							Toast.makeText(getBaseContext(), "请求连接失败！",
									Toast.LENGTH_SHORT).show();
							e.printStackTrace();
						}
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError arg0) {
						ip = "ws://180.153.88.58:8156";
						InItData(ip);
						Toast.makeText(getBaseContext(), "网络请求失败",
								Toast.LENGTH_LONG).show();
					}
				}) {

			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("cmd", "getWebSocket");
				return map;
			}
		};
		request.setTag("abcPost");
		//AppLiction.getHttpQueue().add(request);

	}
	@Override
	public void onDestroy() {
		mWebSocket.onDestory();
		LocalBroadcastManager.getInstance(this)
				.unregisterReceiver(mSendMessage);
		super.onDestroy();
	}

	/**
	 * 通过广播的方式向客户端发送消息，
	 * 

	 * @param bundle
	 *            携带数据，具有一定的格式，cmd,code,message,data;
	 */
	public void sendByBroadcast(Bundle bundle) {
		Intent intent = new Intent();
		intent.putExtras(bundle);
		intent.setAction(Constants.ACTION_RECIVER_MESSAGE);
		LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
		// sendBroadcast(intent);
	}

	/**
	 * 通过信使想客户端发送消息，
	 * 

	 * @param bundle
	 *            封装了的数据
	 */
	public void sendByMessager(Bundle bundle) {
		if (mClient == null)
			return;
		try {
			Message message = Message.obtain();
			message.what = BS_ON_DATA;
			message.setData(bundle);
			mClient.send(message);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	Notification notification;
	NotificationManager notificationManager;

	/**
	 * 监听来自服务端的消息， 解析服务端的消息， 做一些额外的处理，保存登陆后返回的信息 处理消息
	 */
	@Override
	public void onMessage(final String msg) {
		Log.i(TAG, "onMessage:" + msg);

		Log.i(TAG, "第二次:" + mExecutors == null ? "空" : "不为空");
		try {	mExecutors.submit(new Runnable() {
			@Override
			public void run() {
				Bundle bundle = new Bundle();
				int code;
				try {
					//这里把数据转换成模型
					int cmd = ParseMessage.parse(msg, bundle,
							getApplicationContext());
					switch (cmd) {

						case CMD_LOGIN:// 当断线后，有从新连接了，需将消息通过Messager发送给货物列表
							code = bundle.getInt("code");
							if (code == 0) {




							}
							sendByBroadcast(bundle);
							break;

						default:
							sendByBroadcast(bundle);
							break;
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		});

		}catch (Exception e)
		{

		}


	}


}
