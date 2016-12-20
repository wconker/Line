package com.android.line.model;

import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable;

import com.android.line.utils.JSONUtils;
import com.android.line.utils.SharedPreferencesUtils;


public class PictureBean implements Parcelable {

	public String picurl;

	public PictureBean() {
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(picurl);
	};

	public static final Creator<PictureBean> CREATOR = new Creator<PictureBean>() {

		@Override
		public PictureBean createFromParcel(Parcel source) {
			return new PictureBean(source);
		}

		@Override
		public PictureBean[] newArray(int size) {
			return new PictureBean[size];
		}
	};

	protected PictureBean(Parcel in) {
		picurl = in.readString();
	}

	public void saveToSP(Context context) {
		Editor editor = SharedPreferencesUtils.getEditor(context);
		editor.putString("picurl", picurl);
		editor.commit();
	}

	/**
	 * 从sharePreferences中读取个人信息
	 * 
	 * @param context
	 */
	public void readFromSP(Context context) {
		SharedPreferences preferences = SharedPreferencesUtils
				.getSharedPreferences(context);
		picurl = preferences.getString("picurl", "");
	}

	/**
	 * 从JSON数据中创建PersonBean;
	 * 
	 * @param object
	 * @return
	 */
	public static PictureBean createFromJSON(JSONObject object) {
		PictureBean bean = new PictureBean();
		bean.picurl = JSONUtils.getString(object, "PICURL");
		return bean;
	}

}
