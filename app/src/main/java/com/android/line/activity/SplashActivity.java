package com.android.line.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.android.line.R;
import com.android.line.boradcast.Commands;
import com.android.line.boradcast.MessageExchange;
import com.android.line.server.BaseService;
import com.android.line.utils.Constants;
import com.android.line.utils.SharedPreferencesUtils;
import com.android.line.utils.VersionUtils;

import java.net.Inet4Address;
import java.util.List;

import butterknife.Bind;


/**
 * 
 * @类描述：启动页面，展示LOGO
 * @项目名称：HongBao
 * @包名： com.eqiyun.android.activity
 * @类名称：SplashActivity
 * @创建人：SoftSea
 * @创建时间：2015-4-30上午9:53:56
 * @修改人：SoftSea
 * @修改时间：2015-4-30上午9:53:56
 * @修改备注：
 * @version v1.0
 * @see [nothing]
 * @bug [nothing]
 * @Copyright go3c
 * @mail *@qq.com
 */
public class SplashActivity extends Activity implements MessageExchange.OnMessageListener {
	private static final long mTime = 1000;
	private MessageExchange mExchange;
	Bitmap bitmap;
	String mInfo;
	private boolean isrun;
	String mAccount = "";
	String mPassword = "";
	private Handler mHandler = new Handler();
	Dialog mDialog;
	boolean isfrist = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		startService(new Intent(SplashActivity.this, BaseService.class));
		mExchange = new MessageExchange(this, this);
		mExchange.registerReceiver();
		setContentView(R.layout.activity_splash);
		VersionUtils.setWindow(this);
		final SharedPreferences sp = SharedPreferencesUtils
				.getSharedPreferences(this);
		isfrist = true;
		mAccount = sp.getString(Constants.ACCOUNT_USERNAME, "");
		mPassword = sp.getString(Constants.ACCOUNT_PASSWORD, "");


		new AsyncTask<Void, Void, Void>() {

			@Override
			protected Void doInBackground(Void... params) {

				// mHandler.postDelayed(mRunnable, 3000);
				try {
					Thread.sleep(mTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return null;
			}
			@Override
			protected void onPostExecute(Void result) {

				mExchange.sendMessage(Commands.login(mAccount, mPassword,
						SplashActivity.this));

			}

		}.execute();

	}

	/**
	 * 用来判断服务是否运行.
	 * @param context
	 * @param className 判断的服务名字
	 * @return true 在运行 false 不在运行
	 */
	public static boolean isServiceRunning(Context mContext,String className) {
		boolean isRunning = false;
		ActivityManager activityManager = (ActivityManager)
				mContext.getSystemService(Context.ACTIVITY_SERVICE);
		List<ActivityManager.RunningServiceInfo> serviceList
				= activityManager.getRunningServices(30);
		if (!(serviceList.size()>0)) {
			return false;
		}
		for (int i=0; i<serviceList.size(); i++) {
			if (serviceList.get(i).service.getClassName().equals(className) == true) {
				isRunning = true;
				break;
			}
		}
		return isRunning;
	}


	@Override
	protected void onResume() {


		super.onResume();
	}

	@Override
	protected void onPause() {
		//mExchange.unregisterReceiver();
		super.onPause();
	}

	@Override
	public void onMessage(int cmd, int code, String message, Bundle data) {

		switch (cmd) {
		case Constants.CMD_LOGIN: //登录
			if (mDialog != null) {
				mDialog.dismiss();
			}
			if (code == 0 && isfrist) {
				isfrist = false;
				mHandler.removeCallbacks(mRunnable);
				Intent intent = new Intent();
			intent.setClass(SplashActivity.this, Index.class);
			startActivity(intent);
			finish();
		}
			Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}

	}

	private Runnable mRunnable = new Runnable() {

		public void run() {
			if (mDialog != null) {
				mDialog.dismiss();
			}
			mHandler.removeCallbacks(mRunnable);
			Intent intent = new Intent();
			intent.setClass(SplashActivity.this, LoginActivity.class);
			startActivity(intent);
			finish();
		}

	};
}
