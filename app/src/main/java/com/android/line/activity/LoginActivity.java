package com.android.line.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.line.R;
import com.android.line.boradcast.Commands;
import com.android.line.boradcast.MessageExchange;
import com.android.line.utils.CompareToVersion;
import com.android.line.utils.Constants;
import com.android.line.utils.SharedPreferencesUtils;
import com.android.line.utils.ToolsUtils;
import com.android.line.utils.VersionUtils;


/**
 * 登陆界面 当自动登陆时，会弹出一个对话框，显示自动登陆中。
 * 
 * @author cuimingqiang at 2014-10-18
 * 
 */
public class LoginActivity extends Activity implements MessageExchange.OnMessageListener,
		OnClickListener {
	private MessageExchange mExchange;
	private EditText mAccount;
	private EditText mPassword;
	private CheckBox mRemember;
	private TextView mForgot,currentversion;
	private Button mRegister;
	private Button mVisitor;
	private Button mSubmit,login_by_sms;
	private String mUsername;
	private String mPwd;
	private AlertDialog mDialog;
	private Button mVersion;

	private CompareToVersion mCompareToVersion;
	boolean islogin = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		VersionUtils.setWindow(this);
		mExchange = new MessageExchange(this, this);
		mAccount = (EditText) findViewById(R.id.login_number_et);
		mPassword = (EditText) findViewById(R.id.login_password_et);
		mRemember = (CheckBox) findViewById(R.id.login_remember_cb);
		mRegister = (Button) findViewById(R.id.login_register_b);
		mVisitor = (Button) findViewById(R.id.login_visitor_b);
		mVersion = (Button) findViewById(R.id.loginvison);
		login_by_sms=(Button) findViewById(R.id.login_by_sms);
		currentversion=(TextView) this.findViewById(R.id.currentversion);
		mRemember.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// 记住口令
				SharedPreferencesUtils.getEditor(LoginActivity.this)
						.putBoolean(Constants.ACCOUNT_REMEMBER, isChecked)
						.commit();
			}
		});
		mForgot = (TextView) findViewById(R.id.login_forgot_tv);
		mSubmit = (Button) findViewById(R.id.login_submit_b);
		mForgot.setOnClickListener(this);
		SharedPreferences sp = SharedPreferencesUtils
				.getSharedPreferences(this);
		mUsername = sp.getString(Constants.ACCOUNT_USERNAME, "");
		mPwd = sp.getString(Constants.ACCOUNT_PASSWORD, "");
		mAccount.setText(mUsername);
		mPassword.setText(mPwd);
		String account = mAccount.getText().toString();
		// if (account.equals("")) {
		// mRegister.setVisibility(View.VISIBLE);
		// } else {
		// mRegister.setVisibility(View.GONE);
		// }
		Boolean remember = SharedPreferencesUtils.getSharedPreferences(this)
				.getBoolean(Constants.ACCOUNT_REMEMBER, true);
		/**
		 * 记住口令
		 */
		if (remember && mUsername.trim().length() == 11) {

			login(mUsername, mPwd);

		}
		mCompareToVersion = new CompareToVersion();
		String versionName = ToolsUtils.getAppVersionName(this);
		currentversion.setText("当前版本-" + versionName );
		
		mVersion.setOnClickListener(this);
		mRemember.setChecked(remember);
		mSubmit.setOnClickListener(this);
		mRegister.setOnClickListener(this);
		mVisitor.setOnClickListener(this);
		login_by_sms.setOnClickListener(this);

	}

	// 收到服务端消息
	@Override
	public void onMessage(int cmd, int code, String message, final Bundle data) {

	}

	@Override
	protected void onResume() {
		mExchange.registerReceiver();
		islogin = false;
		super.onResume();
	}

	@Override
	protected void onPause() {
		mExchange.unregisterReceiver();
		mAccount.clearFocus();
		mPassword.clearFocus();
		super.onPause();
	}

	@Override
	public void onClick(View v) {


	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 400 && resultCode == 401) {
			mUsername = data.getStringExtra("name");
			mPwd = data.getStringExtra("pwd");
			mAccount.setText(mUsername);
			mPassword.setText(mPwd);
			login(mUsername, mPwd);

		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	/**
	 * 执行登陆操作。
	 */
	private void login(String name, String pwd) {
		islogin = false;
		/**
		 * 判断是否连接网络
		 */
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnectedOrConnecting()) {
			if (mUsername.equals("") || mUsername == "") {
				Toast.makeText(getApplicationContext(), "请输入你的手机号码！",
						Toast.LENGTH_SHORT).show();
				mSubmit.setEnabled(true);
			} else {
				View view = getLayoutInflater().inflate(
						R.layout.dialog_autologin, null);
				mDialog = new AlertDialog.Builder(this).setView(view).show();
				mDialog.setCanceledOnTouchOutside(false);
				mExchange.sendMessage(Commands.login(name, pwd,
						LoginActivity.this));
				mSubmit.setEnabled(true);
			}
		} else {
			Toast.makeText(getApplicationContext(), "网络未连接，请重新设置网络！",
					Toast.LENGTH_SHORT).show();
			mSubmit.setEnabled(true);
		}

	}

	/**
	 * 保存用户名与口令
	 */
	public void saveAccount() {
		Editor editor = SharedPreferencesUtils.getEditor(this);
		editor.putString(Constants.ACCOUNT_USERNAME, mUsername);
		editor.putString(Constants.ACCOUNT_PASSWORD, mPwd);
		editor.commit();

	}

	void showDialog(String nowVersion, String nowInfo) {

	}
}
