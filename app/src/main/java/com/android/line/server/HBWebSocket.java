package com.android.line.server;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.android.line.utils.MCrypt;


/**
 * 与服务端通信的主类，一般不做修改 对外提供了一个借口，将服务端或客户端的消息原样传递出去。 实现了OnMessage接口
 * 
 * 
 */
public class HBWebSocket {
	private static final String TAG = "xzw";
	private String mUrlWan = "";
	private Draft_17 mDraft_17 = new Draft_17();
	private volatile WebSocketClient mClient;
	private OnMessage Message;
	private ExecutorService mExecutors;
	private Context mContext;
	private MCrypt mCrypt = new MCrypt();

	public HBWebSocket(OnMessage onMessage, String url) {
		Message = onMessage;
		mExecutors = Executors.newFixedThreadPool(1);
		mUrlWan = url;
		startServer();
	}
	public interface OnMessage {
		void onMessage(String msg);
	}
	private volatile boolean mSwitch = true;

	public void onDestory() {
		mSwitch = false;
		if (mClient == null) {
			return;
		} else {
			mClient.close();
			mClient = null;
		}
		mExecutors.shutdown();
	}

	/**
	 * 发送信息
	 * 
	 * @param msg
	 *            消息
	 */
	public void send(final String msg) {
		mExecutors.submit(new Runnable() {
			@Override
			public void run() {


				if (mClient != null && mClient.isOpen()) {
					try {
						Log.i(TAG, "进入成功send()");
						mClient.send(msg);
					} catch (Exception e) {
						e.printStackTrace();
						Log.i(TAG, "进入send()方法的异常捕获");
						if (Message != null) {
							Message.onMessage(AppMessage
									.websocketNotConnected());
						}
					}
				} else if (mClient.isConnecting()) {
					Log.i(TAG, "进入send()方法的isConnecting()");
				} else {
					Log.i(TAG, "进入send()方法的else");
					if (Message != null) {
						Message.onMessage(AppMessage.websocketNotConnected());
					}
				}
			}
		});

	}

	class Task implements Runnable {
		@Override
		public void run() {
			try {
				if (mUrlWan.equals("")) {
					Toast.makeText(mContext, "没有获取到连接地址！", Toast.LENGTH_SHORT)
							.show();
					return;
				}
				mClient = new WebSocketClient(new URI(mUrlWan), mDraft_17,
						null, 3000) {
					@Override
					public void onOpen(ServerHandshake handshakedata) {
						Log.i(TAG, "走进onOpen（）方法");
						if (Message != null) {
							Message.onMessage(AppMessage.websocketOnOpen());
						}
					}

					@Override
					public void onMessage(String message) {
						Log.i(TAG, "走进onMessage（）方法" + message);
						if (Message != null) {
							try {
								//Message.onMessage(mCrypt.decrypt(message));
								 Message.onMessage(message);
							} catch (Exception e) {
								// Message.onMessage("");
								e.printStackTrace();
							}
						}
					}

					@Override
					public void onError(Exception ex) {
						Log.i(TAG, "走进onError（）方法" + ex.getMessage());
						Log.i(TAG,
								"走进onError（）方法getlocalizedmessage()"
										+ ex.getLocalizedMessage());
						if (Message != null) {
							Message.onMessage(AppMessage.websocketOnError());
						}
					}

					@Override
					public void onClose(int code, String reason, boolean remote) {
						Log.i(TAG, "onClose（）方法");
						if (Message != null) {
							Message.onMessage(AppMessage.websocketOnClose());
						}
						if (mSwitch) {
							if (mClient != null) {
								mClient.close();
							}
							mClient = null;
							circleConnection();
						}
					}
				};
				Log.i(TAG, "客户端建立连接connect()");
				mClient.connect();
			} catch (URISyntaxException e) {
				Log.i(TAG, "Task URISyntaxException" + e.getMessage());
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
				Log.i(TAG, "Task 不知道怎么错了" + e.getMessage());

			}
		}

	}

	/**
	 * 开启联网线程
	 */
	public void startServer() {
		Log.i(TAG, "开启线程");
		new Thread(new Task()).start();
	}

	/**
	 * 链接断开后，每过3秒尝试一次连接。
	 */
	private void circleConnection() {

		if (mClient != null)
			return;
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (mSwitch) {
					startServer();
				}
				Log.i(TAG, "检测已关闭");
			}
		}).start();

	}
}
