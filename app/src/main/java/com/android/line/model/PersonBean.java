package com.android.line.model;

import java.util.ArrayList;

import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable;

import com.android.line.utils.JSONUtils;
import com.android.line.utils.SharedPreferencesUtils;

/**
 * 个人信息
 * 登陆后反回的数据，
 * 查看会员信息的数据
 * @author cuimingqiang at 2014-10-18
 *
 */
public class PersonBean implements Parcelable {
	/**
	 * 姓名
	 */
	public String xm;
	/**
	 * 信誉
	 */
	public String ptxy;
	/**
	 * 用户类型
	 */
	public String yhlx;
	/**
	 * 性别
	 */
	public String xb;
	/**
	 * 截止有效期
	 */
	public String jzyxq;
	/**
	 * 驾驶证号
	 */
	public String jszh;
	/**
	 * 车牌号
	 */
	public String cph;
	/**
	 * 车长
	 */
	public String cc;
	/**
	 * 载重
	 */
	public String zz;
	/**
	 * 车型
	 */
	public String cx;
	/**
	 * 公司名称
	 */
	public String gsmc;
	/**
	 * 详细地址
	 */
	public String xxdz;
	/**
	 * 联系电话1
	 */
	public String lxdh1;
	/**
	 * 联系电话2
	 */
	public String lxdh2;
	/**
	 * 联系电话,所以的电话以逗号隔开，组成一个字符串储存
	 */
	private String mLXDH;
	/**
	 * 身份证号码
	 */
	public String sfzh;
	/**
	 * 身份验证标识
	 */
	public String sfyzflag;
	
	/**
	 * 照片
	 */
	public String image;
	
	public ArrayList<String> mPhones;
	public PersonBean() {};

	@Override
	public int describeContents() {
		return 0;
	}
	private void initPhones(){
		String[] phones = mLXDH.split("\\,");
		if(mPhones==null)
			mPhones = new ArrayList<String>();
		for(String phone:phones){
			mPhones.add(phone);
		}
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(xm);
		dest.writeString(ptxy);
		dest.writeString(yhlx);
		dest.writeString(xb);
		dest.writeString(jzyxq);
		dest.writeString(jszh);
		dest.writeString(cph);
		dest.writeString(cc);
		dest.writeString(zz);
		dest.writeString(cx);
		dest.writeString(sfyzflag);
		dest.writeString(gsmc);
		dest.writeString(xxdz);
		dest.writeString(lxdh1);
		dest.writeString(lxdh2);
		dest.writeString(mLXDH);
		dest.writeString(image);
		dest.writeString(sfzh);

	}

	public static final Creator<PersonBean> CREATOR = new Creator<PersonBean>() {

		@Override
		public PersonBean createFromParcel(Parcel source) {
			return new PersonBean(source);
		}

		@Override
		public PersonBean[] newArray(int size) {
			return new PersonBean[size];
		}
	};


	protected PersonBean(Parcel in) {
		xm = in.readString();
		ptxy = in.readString();
		yhlx = in.readString();
		xb = in.readString();
		jzyxq = in.readString();
		jszh = in.readString();
		cph = in.readString();
		cc = in.readString();
		zz = in.readString();
		cx = in.readString();
		sfyzflag = in.readString();
		sfzh=in.readString();
		
		gsmc = in.readString();
		xxdz = in.readString();
		lxdh1 = in.readString();
		lxdh2 = in.readString();
		mLXDH  = in.readString();
		image=in.readString();
		

		initPhones();
	}


	/**
	 * 保存文件到sharePreferences
	 * 
	 * @param context
	 */
	public void saveToSP(Context context) {
		Editor editor = SharedPreferencesUtils.getEditor(context);
		editor.putString("xm", xm);
		editor.putString("ptxy", ptxy);
		editor.putString("yhlx", yhlx);
		editor.putString("jzyxq", jzyxq);
		editor.putString("cph", cph);
		editor.putString("jszh", jszh);
		editor.putString("cc", cc);
		editor.putString("zz", zz);
		editor.putString("cx", cx);
		editor.putString("image", image);
		editor.putString("sfzh", sfzh);
		editor.putString("sfyzflag", sfyzflag);
//		editor.putString("gsmc", gsmc);
//		editor.putString("xxdz", xxdz);
//		editor.putString("lxdh1", lxdh1);
//		editor.putString("lxdh2", lxdh2);
		
		editor.putString("lxdh", mLXDH);
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
		xm = preferences.getString("xm", "");
		ptxy = preferences.getString("ptxy", "");
		yhlx = preferences.getString("yhlx", "");
		xb = preferences.getString("xb", "");
		jzyxq = preferences.getString("jzyxq", "");
		cph = preferences.getString("cph", "");
		jszh = preferences.getString("jszh", "");
		cc = preferences.getString("cc", "");
		zz = preferences.getString("zz", "");
		cx = preferences.getString("cx", "");
		mLXDH = preferences.getString("lxdh", "");
		image=preferences.getString("image", "");
		sfzh=preferences.getString("sfzh", "");
		sfyzflag=preferences.getString("sfyzflag", "");
		initPhones();
	}
	/**
	 * 从JSON数据中创建PersonBean;
	 * @param object
	 * @return
	 */
	public static PersonBean createFromJSON(JSONObject object) {
		PersonBean bean = new PersonBean();
		bean.xm = JSONUtils.getString(object, "xm");
		bean.ptxy = JSONUtils.getString(object, "ptxy");
		bean.cc = JSONUtils.getString(object,"cc");
		bean.zz = JSONUtils.getString(object, "zz");
		bean.cph = JSONUtils.getString(object, "cph");
		bean.cx = JSONUtils.getString(object, "cx");
		bean.sfyzflag = JSONUtils.getString(object, "dw");
		bean.jszh = JSONUtils.getString(object, "jszh");
		bean.xb = JSONUtils.getString(object, "xb");
		bean.yhlx = JSONUtils.getString(object, "yhlx");
		bean.jzyxq = JSONUtils.getString(object, "jzyxq");
		bean.image=JSONUtils.getString(object, "image");
		bean.sfzh=JSONUtils.getString(object, "sfzh");
		bean.sfyzflag=JSONUtils.getString(object, "sfyzflag");
		
		bean.gsmc = JSONUtils.getString(object, "gsmc");
		bean.xxdz = JSONUtils.getString(object, "xxdz");
		bean.lxdh1 = JSONUtils.getString(object, "lxdh1");
		bean.lxdh2 = JSONUtils.getString(object, "lxdh2");
		
	
		
		bean.mLXDH = JSONUtils.getString(object,"lxdh");
		bean.initPhones();
		return bean;
	}
}
