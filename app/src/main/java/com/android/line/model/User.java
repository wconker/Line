package com.android.line.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.android.line.utils.JSONUtils;

import org.json.JSONObject;

/**
 * Created by kanghui on 2016/11/16.
 */
public class User implements Parcelable {

    //用户姓名
    public  String username;
    //用户类型
    public String usertype;
    //联系电话
    public String phone;
    // 企业名称
    public  String enterprisename;
    // 企业编号
    public  String enterpriseno;
    //用户id
    public  String userid;



    @Override
    public int describeContents() {
        return 0;
    }
    public static final Creator<User> CREATOR = new Creator<User>() {

        @Override
        public User createFromParcel(Parcel source) {
            return new User();
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(phone);
        dest.writeString(userid);
        dest.writeString(username);
        dest.writeString(usertype);
        dest.writeString(enterprisename);

    }
    /**
     * 从JSON数据中创建UserBean;
     * @param object
     * @return
     */
    public static User createFromJSON(JSONObject object) {
        User user = new User();

        user.username = JSONUtils.getString(object, "UserName");
        user.usertype = JSONUtils.getString(object, "UserType");
        user.enterprisename = JSONUtils.getString(object,"EnterpriseName");
        user.phone = JSONUtils.getString(object, "MobileNumber");
         user.userid = JSONUtils.getString(object, "userID");


        return user;
    }
}
