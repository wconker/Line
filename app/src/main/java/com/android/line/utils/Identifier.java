package com.android.line.utils;

import android.content.Context;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;
/**
 * 账号与手机绑定
 * @author cuimingqiang
 *
 */
public class Identifier {
	
	/**
	 * 
	 * @描述:获取硬件指纹
	 * @方法名: getHardwareInfo
	 * @param context
	 * @return
	 * @返回类型 String
	 * @创建人 SoftSea
	 * @创建时间 2015-5-11上午11:26:20
	 * @修改人 项振旺
	 * @修改时间 2015-5-11上午11:26:20
	 * @修改备注
	 * @since
	 * @throws
	 */
	@SuppressWarnings("unused")
	public static String getHardwareInfo(Context context){

		String m_szLongID = "";
		TelephonyManager TelephonyMgr = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		// The IMEI: 仅仅只对Android手机有效:
		String m_szImei = TelephonyMgr.getDeviceId(); // Requires
		Log.i("TAG", "m_szImei:" + m_szImei);

		// 装有SIM卡的设备，可以通过下面的方法获取到Sim Serial Number
		String SimSerialNumber = TelephonyMgr.getSimSerialNumber();
		Log.i("TAG", "SimSerialNumber:" + SimSerialNumber);

		// Android系统2.3版本以上可以通过下面的方法得到Serial Number，且非手机设备也可以通过该接口获取
		String SerialNumber = Build.SERIAL;
		Log.i("TAG", "SerialNumber:" + SerialNumber);

		// Pseudo-Unique ID, 这个在任何Android手机中都有效
		String m_szDevIDShort = "35"
				+ // we make this look like a valid IMEI
				Build.BOARD.length() % 10 + Build.BRAND.length() % 10
				+ Build.CPU_ABI.length() % 10 + Build.DEVICE.length() % 10
				+ Build.DISPLAY.length() % 10 + Build.HOST.length() % 10
				+ Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10
				+ Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10
				+ Build.TAGS.length() % 10 + Build.TYPE.length() % 10
				+ Build.USER.length() % 10; // 13 digits
		Log.i("TAG", "m_szDevIDShort:" + m_szDevIDShort);

		// 这个ID会改变如果进行了出厂设置。并且，如果某个Andorid手机被Root过的话，这个ID也可以被任意改变
		String m_szAndroidID = Secure.getString(context.getContentResolver(),
				Secure.ANDROID_ID);
		Log.i("TAG", "m_szAndroidID:" + m_szAndroidID);

		if (m_szImei!=null) {
			m_szLongID = m_szImei;
		} else if (SimSerialNumber!=null) {
			m_szLongID = SimSerialNumber;
		} else if (SerialNumber!=null) {
			m_szLongID = SerialNumber;
		} else if (m_szDevIDShort!=null||!m_szDevIDShort.equals("")) {
			m_szLongID = m_szDevIDShort;
		} else if (m_szAndroidID!=null||!m_szAndroidID.equals("")) {
			m_szLongID = m_szAndroidID;
		} else {
			m_szLongID = "0000000000000000";
		}
		return m_szLongID;
	}

}
