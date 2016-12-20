package com.android.line.utils;

/**
 * 定义常量
 * 
 * @author cuimingqiang at 2014-10-18
 * 
 */
public class Constants {
	/**
	 * 接受服务端信息
	 */
	public static final String ACTION_RECIVER_MESSAGE = "com.eqiyun.android.reciver";
	/**
	 * 向服务端发送消息
	 */
	public static final String ACTION_SEND_MESSAGE = "com.eqiyun.android.send";
	/**
	 * 启动BaseService服务的ACTION
	 */
	public static final String ACTION_BASESERVICE = "com.eqiyun.android.service.BaseService";

	public static final String ACTION_FRIST = "com.eqiyun.android.frist";
	/**
	 * SharePreference数据库名称
	 */
	public static final String SHARE_SP = "com.eqiyun.sp";
	public static final String ACCOUNT_SFZ_PHOTO = "photo_sfz";
	public static final String APPID = "0cc4e4fb5f124403cb87b8d9b5f68e53";
	public static final String NOTIFICTION_SP = "com.eqiyun.findgoodsfragment";
	/**
	 * 记住密码
	 */
	public static final String ACCOUNT_REMEMBER = "com.eqiyun.remember";
	/**
	 * 账户
	 */
	public static final String ACCOUNT_USERNAME = "com.eqiyun.username";
	/**
	 * 密码
	 */
	public static final String ACCOUNT_PASSWORD = "com.eqiyun.password";
	public static final String ACCOUNT_NAME = "com.eqiyun.name";

	/**
	 * app 下载地址
	 * */
	public static final String APPURL = "http://www.softsea.cn/app/eqiyun/1.apk";

	public static final String HOME_INFO = "com.eqiyun.homeinfo";

	// 经度
	public static final String MAP_JD = "com.eqiyun.jd";
	// 纬度
	public static final String MAP_WD = "com.eqiyun.wd";
	// 控制进入相册
	public static int PHOTO = 1;
	/* 默认字体大小 */
	public static final int DEAFULT_FONT_SIZE = 15;
	/* 设置字体大小 */
	public static final String KEY_FONT_SIZE = "KEY_FONT_SIZE";
	/* 新消息 */
	public static final String KEY_NEW_VOICE = "KEY_NEW_VOICE";
	/* 新消息 通知 */
	public static final String KEY_NEWINFO_VOICE = "KEY_NEWINFO_VOICE";
	/* 消息提示音 */
	public static final String KEY_RECINFO_VOICE = "KEY_RECINFO_VOICE";

	/* 消息振动提示 */
	public static final String KEY_RECINFO_VIBRATION = "KEY_RECINFO_VIBRATION";
	/**
	 * 微信分享APP的ID
	 */
	public static final String WX_APP_ID = "wx768adb1ea2e1cd9c";
	/**
	 * 微信分享密钥
	 */
	public static final String WX_APP_SECRET = "8bc71e5969c5a8c5a9114b5911584318";
	public static final String APP_SECRET = "";
	/**
	 * QQ分享的ID
	 */
	public static final String QQ_APP_ID = "1103294279";
	/**
	 * 百度地图ID
	 */
	public static final String BD_MAP_ID = "5435946";

	public static final int CMD_GETIPHONELIST = 0;
	/**
	 * 登录命令
	 */
	public static final int CMD_LOGIN = 1;
	/**
	 * 找回密码
	 */
	public static final int CMD_FIND_PWD = 2;
	/**
	 * 我的发布记录
	 */
	public static final int CMD_MYGOODSINFO = 3;
	/**
	 * 发布调车信息
	 */
	public static final int CMD_ADDGOODSINFO = 4;
	/**
	 * 获取验证码
	 */
	public static final int CMD_GETSMSCODE = 5;
	/**
	 * 获取货源信息详情
	 */
	public static final int CMD_GETGOODSINFO = 6;
	/**
	 * 更新货源信息详情
	 */
	public static final int CMD_UPDATEGOODSINFO = 7;
	/**
	 * 删除调车信息
	 */
	public static final int CMD_DELETEGOODSINFO = 8;
	/**
	 * 获取车源列表
	 */
	public static final int CMD_GETCARSLIST = 9;
	/**
	 * 获取车源信息详情
	 */
	public static final int CMD_GETCARSINFO = 10;
	/**
	 * 设置车辆状态，空车，满载
	 */
	public static final int CMD_SETCARSTATUS = 11;
	/**
	 * 获取车辆状态
	 */
	public static final int CMD_GETCARSTATUS = 12;
	/**
	 * 获取长跑线路
	 */
	public static final int CMD_GETUSEDLINE = 13;
	/**
	 * 获取货源列表
	 */
	public static final int CMD_GETGOODSLIST = 14;
	/**
	 * 查看会员信息详情
	 */
	public static final int CMD_READCONTACT = 15;
	/**
	 * 查看交易记录
	 */
	public static final int CMD_GETDEALLIST = 16;
	/**
	 * 评价
	 */
	public static final int CMD_SETEVALUATION = 17;
	/**
	 * 获取交易诚信记录
	 */
	public static final int CMD_GETRECORDS = 18;
	/**
	 * 获取我的车队
	 */
	public static final int CMD_GETMYCARSLIST = 19;
	/**
	 * 添加车辆好友
	 */
	public static final int CMD_ADDMYCARS = 20;
	/**
	 * 删除车辆好友
	 */
	public static final int CMD_REMOVEMYCARSLIST = 21;
	/**
	 * 获取用户信息
	 */
	public static final int CMD_GETUSERINFO = 22;
	/**
	 * 设置用户信息
	 */
	public static final int CMD_SETUSERINFO = 23;
	/**
	 * 获取车长
	 */
	public static final int CMD_GETCARLENGHT = 24;
	/**
	 * 设置车长
	 */
	public static final int CMD_SETCARLENGTH = 25;
	/**
	 * 添加常跑路线
	 */
	public static final int CMD_ADDUSERDLINE = 26;
	/**
	 * 删除常跑路线
	 */
	public static final int CMD_REMOVEUSERDLINE = 27;
	/**
	 * 修改密码
	 */
	public static final int CMD_UPDATEPASSWORD = 28;
	/**
	 * 获取账户信息
	 */
	public static final int CMD_GETUSERACCOUNT = 29;
	/**
	 * 更新地理位置
	 */
	public static final int CMD_UPDATELOCATIONINFO = 30;
	/**
	 * 指定承运人
	 */
	public static final int CMD_PROVIDETHEARRIER = 31;
	/**
	 * 广告广播
	 */
	public static final int CMD_ADBROADCAST = 32;
	/**
	 * 新货源信息
	 */
	public static final int CMD_RECINFO = 33;
	/**
	 * 心跳包
	 */
	public static final int CMD_CHECKONLINE = 34;
	/**
	 * 收听常跑路线
	 */
	public static final int CMD_SUBUSEDLINE = 35;
	/**
	 * 取消收听常跑路线
	 */
	public static final int CMD_UNSUBUSEDLINE = 36;
	/**
	 * 服务端请求定位
	 */
	public static final int CMD_NEEDLOCINFO = 37;
	/**
	 * 获取收藏列表
	 */
	public static final int CMD_GETFAVORITESLIST = 38;
	/**
	 * 取消收藏
	 */
	public static final int CMD_REMOVEFAVORITES = 39;
	/**
	 * 添加收藏
	 */
	public static final int CMD_ADDFAVORITES = 40;
	/**
	 * 获取最新位置
	 */
	public static final int CMD_GETLOCINFO = 41;
	/**
	 * 申请交易
	 */
	public static final int CMD_APPLICATIONTRANSACTION = 42;
	/**
	 * 同意交易
	 */
	public static final int CMD_AGREETRANSACTION = 43;
	/**
	 * 拒绝交易
	 */
	public static final int CMD_DISAGREETRANSACTION = 44;
	/**
	 * 取消交易
	 */
	public static final int CMD_REMOVETRANSACTION = 45;
	/**
	 * 交易评价
	 */
	public static final int CMD_EVALUATIONTRANSACTION = 46;
	/**
	 * 取我的申请
	 */
	public static final int CMD_GETMYAGREE = 47;
	/**
	 * 向我申请
	 */
	public static final int CMD_GETAGREETOME = 48;
	/**
	 * 待评列表
	 */
	public static final int CMD_GETTOEVALUATION = 49;
	/**
	 * 交易记录
	 */
	public static final int CMD_GETTRANSACTIONLIST = 50;
	/**
	 * 诚信记录
	 */
	public static final int CMD_GETEVALUATIONLIST = 51;
	/**
	 * 注册命令
	 */
	public static final int CMD_REGISTER = 52;
	/**
	 * 获取会员信息
	 */
	public static final int CMD_GETMEMBERINFO = 53;
	/**
	 * 未读信息
	 */
	public static final int CMD_GETMYBUSINESS = 54;
	/**
	 * 获取图片资源
	 */
	public static final int CMD_GETIMAGE = 55;
	/**
	 * 服务端通知消息更新
	 */
	public static final int CMD_NOTIFICATION = 56;
	/**
	 * 删除信息
	 */
	public static final int CMD_DELINFO = 57;
	/**
	 * 成交信息
	 */
	public static final int CMD_DEALINFO = 58;
	/**
	 * 服务的广播，用户未登陆
	 */
	public static final int CMD_ERROR = 59;
	/**
	 * 支付消息
	 */
	public static final int CMD_PAY = 60;

	/**
	 * 支付类型的选项
	 */
	public static final int CMD_PAYITEM = 61;
	/**
	 * 邀请码
	 */
	public static final int CMD_SETINVITEDCODE = 62;

	/**
	 * 首页广告
	 */
	public static final int CMD_GETHOMELIST = 63;
	/**
	 * 首页广告
	 */
	public static final int CMD_ADCLICKED = 64;

	public static final int CMD_PUSHTRANSPORTCAPACITY = 65;

	/**
	 * 取货源数量
	 */
	public static final int CMD_GETINFONUMBER = 66;
	/**
	 * 删除车源信息
	 */
	public static final int CMD_DELETECARSINFO = 67;
	/**
	 * 发布车源信息
	 */
	public static final int CMD_ADDCARSINFO = 68;
	// 我的发布记录
	public static final int CMD_GETMYRELEASED = 72;
	public static final int CMD_READCARSCONTACT = 69;
	// 设置常用地址
	public static final int CMD_GETLOGISTICS = 84;
	public static final int CMD_ADDLOGISTICS = 85;
	// 首页控件
	public static final int CMD_GETCONMPONENT = 98;

	public static final int CMD_GETAD = 104;

	// 获取版本号
	public static final int CMD_GETVERSION = 105;
	public static final int CMD_GETBALANCE = 111;
	// 获取产品分类
	public static final int CMD_GETCPFLLIST = 112;
	// 获取产品列表
	public static final int CMD_GETDSCPLIST = 113;
	// 获取产品详情
	public static final int CMD_GETDSCPINFO = 114;
	// 提交订单商城
	public static final int CMD_ADDRESERVE = 115;
	// 获取商城我的订单
	public static final int CMD_GETMYDSDDINFO = 116;
	// 商城支付宝支付
	public static final int CMD_ALIPAYCP = 117;
	// 商城取消订单
	public static final int CMD_CANCELCP = 118;
	// 商城删除订单
	public static final int CMD_DELETERESERVE = 119;
	// 商城首页
	public static final int CMD_GETSHOPPINGLIST = 120;
	// 获取城市列表
	public static final int CMD_GETCITYLIST = 121;
	// 商户界面
	public static final int CMD_GETDTINFO = 122;
	
	//获取同意支付的卡
	public static final int CMD_GETAGREECARDPAY = 10000;
	
	//同意支付
	public static final int CMD_AGREECARDPAY = 10000;
	
	//取消订单
	public static final int CMD_CANCELCARDPAY = 10000;
	
	
	
	public static final int CMD_GETHYLIST = 10000;
	public static final int CMD_GETCARDXFTODO= 10000;
	public static final int CMD_GETCARDXFLIST = 10000;
	public static final int CMD_GETCARDINFO = 10000;

	/*******************************************************/

	/**
	 * 客户端消息
	 */
	public static final int CMD_CLIENT = -99;
	/**
	 * 网络未连接
	 */
	public static final int WebSocket_NotConnected = -100;
	/**
	 * 网络关闭
	 */
	public static final int WebSocket_OnClose = -101;
	/**
	 * 网络错误
	 */
	public static final int WebSocket_OnError = -102;
	/**
	 * 网络打开
	 */
	public static final int WebSocket_OnOpen = 0;
	/**
	 * 未知错误
	 */
	public static final int Unknown_Error = -1;
}
