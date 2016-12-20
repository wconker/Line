package com.android.line.boradcast;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.util.Log;

import com.android.line.utils.Identifier;


/**
 * 这是一个命令集 封装了所有的命令
 * 
 * @author cuimingqiang at 2014年10月6日
 * 
 */
public class Commands {
	/**
	 * 登录命令
	 * 
	 * @param number
	 *            手机号码
	 * @param password
	 * @return
	 */
	public static Map<String, String> login(String number, String password,
			Context context) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "Comm.User.login");
		map.put("MobileNumber", "18106530102");
		map.put("Password", "1997");
		map.put("UserType", "2");
		map.put("Source", "1");
		map.put("Version", "1.2");
		map.put("city", "杭州");
		return map;
	}

	/**
	 * 验证码登录登录命令
	 * 
	 * @param number
	 *            手机号码
	 * @param password
	 * @return
	 */
	public static Map<String, String> loginbyyzm(String number, String yzm,
			Context context) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "Comm.User.login");
		map.put("MobileNumber", "18106530102");
		map.put("Password", "1997");
		map.put("UserType", "2");
		map.put("Source", "1");
		map.put("Version", "1.2");
		map.put("city", "杭州");
		return map;
	}

	/**
	 * 获取验证码
	 * 
	 * @param number
	 * @return
	 */

	public static Map<String, String> getSmsCode(String number) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getSmsCode");
		map.put("phonenumber", number);
		return map;
	}

	/**
	 * 注册
	 * 
	 * @param number
	 *            手机号码
	 * @param password
	 * @param valid
	 *            验证码
	 * @return
	 */
	public static Map<String, String> register(String number, String password,
			String valid) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "register");
		map.put("phonenumber", number);
		map.put("pwd", password);
		map.put("yzm", valid);
		return map;
	}

	/**
	 * 找回 密码
	 * 
	 * @param number
	 * @return
	 */
	public static Map<String, String> findPassword(String number) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "findPassword");
		map.put("phonenumber", number);
		return map;
	}

	/**
	 * 找回 密码
	 * 
	 * @param number
	 * @return
	 */
	public static Map<String, String> findPassword(String number, String Sms) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "findPassword");
		map.put("phonenumber", number);
		map.put("yzm", Sms);
		return map;
	}

	/**
	 * 发布调车信息
	 * 
	 * @param map
	 *            发布的消息封装在Map里，从UI获取
	 * @return
	 */
	public static Map<String, String> addGoodsInfo(Map<String, String> map) {
		map.put("cmd", "addGoodsInfo");
		return map;
	}

	/**
	 * 我的发布记录
	 * 
	 * @return
	 */
	public static Map<String, String> myGoodsInfo() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "myGoodsInfo");
		return map;
	}

	/**
	 * 获取货源信息详情
	 * 
	 * @param hyid
	 *            货源ID
	 * @return
	 */
	public static Map<String, String> getGoodsInfo(String hyid) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getGoodsInfo");
		map.put("hyid", hyid);
		return map;
	}

	/**
	 * 更新货源信息详情
	 * 
	 * @param map
	 *            封装了的货源的信息
	 * @return
	 */
	public static Map<String, String> updateGoodsInfo(Map<String, String> map) {
		map.put("cmd", "updateGoodsInfo");
		return map;
	}

	/**
	 * 删除调车信息
	 * 
	 * @param hyid
	 *            货源ID
	 * @return
	 */
	public static Map<String, String> deleteGoodsInfo(String hyid) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "deleteGoodsInfo");
		map.put("hyid", hyid);
		return map;
	}

	/**
	 * 获取车源列表
	 * 
	 * @param map
	 * @return
	 */
	public static Map<String, String> getCarsList(Map<String, String> map) {
		map.put("cmd", "getCarsList");
		return map;
	}

	/**
	 * 获取车源信息详情
	 * 
	 * @param cyid
	 *            车源ID
	 * @return
	 */
	public static Map<String, String> getCarsInfo(String cyid) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getCarsInfo");
		map.put("cyid", cyid);
		return map;
	}

	/**
	 * 设置车辆状态，0空载，1满载
	 * 
	 * @param clzt
	 * @return
	 */
	public static Map<String, String> setCarStatus(String clzt) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "setCarStatus");
		map.put("clzt", clzt);
		return map;
	}

	/**
	 * 获取车辆状态
	 * 
	 * @return
	 */
	public static Map<String, String> getCarStatus() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getCarStatus");
		return map;
	}

	/**
	 * 获取常跑路线
	 * 
	 * @return
	 */
	public static Map<String, String> getUsedLine() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getUsedLine");
		return map;
	}

	/**
	 * 获取货源列表
	 * 
	 * @param sfd
	 *            始发地
	 * @param mdd
	 *            目的地
	 * @param type
	 *            加载全部或部分，more,part
	 * @return
	 */
	public static Map<String, String> getGoodsList(String sfd, String mdd,
			String type) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getGoodsList");
		map.put("sfd", sfd);
		map.put("type", type);
		map.put("mdd", mdd);

		return map;
	}

	/**
	 * 获取货源列表
	 * 
	 * @param sfd
	 *            始发地
	 * @param mdd
	 *            目的地
	 * @param type
	 *            加载全部或部分，more,part
	 * @return
	 */
	public static Map<String, String> getGoodsList(String sfd, String mdd,
			String type, boolean ifListne) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getGoodsList");
		map.put("sfd", sfd);
		map.put("type", type);
		map.put("mdd", mdd);
		if (ifListne)
			map.put("qg", "1");
		return map;
	}

	/**
	 * 获取货源列表(重载)
	 * 
	 * @param sfd
	 *            始发地
	 * @param mdd
	 *            目的地
	 * @param type
	 *            加载全部或部分，more,part
	 * @return
	 */
	public static Map<String, String> getGoodsList(String cc, String cx,
			String sfd, String mdd, String type) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getGoodsList");
		map.put("sfd", sfd);
		map.put("cc", cc);
		map.put("cx", cx);
		map.put("type", type);
		map.put("mdd", mdd);
		map.put("qg", "1");
		Log.e("wkh_log", map.toString());
		return map;
	}

	/**
	 * 查看某条记录的联系人及其信息详情
	 * 
	 * @param id
	 *            联系人ID
	 * @return
	 */
	public static Map<String, String> readContact(String hyid) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "readContact");
		map.put("hyid", hyid);
		return map;
	}

	/**
	 * 获取交易记录
	 */
	public static Map<String, String> getDealList() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getDealList");
		return map;
	}

	/**
	 * 评价
	 * 
	 * @param map
	 * @return
	 */
	public static Map<String, String> setEvaluation(Map<String, String> map) {
		map.put("cmd", "setEvaluation");
		return map;
	}

	/**
	 * 获取交易诚信记录
	 * 
	 * @return
	 */
	public static Map<String, String> getRecords() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getRecords");
		return map;
	}

	/**
	 * 获取我的车队
	 * 
	 * @return
	 */
	public static Map<String, String> getMyCarsList() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getMyCarsList");
		return map;
	}

	/**
	 * 车辆添加好友 传参 "cardno"车辆标号 "bz":
	 * 
	 * @return
	 */
	public static Map<String, String> addMyCars(Map<String, String> map) {
		map.put("cmd", "addMyCars");
		return map;
	}

	/**
	 * 删除车辆好友
	 * 
	 * @param cardno
	 *            车辆编号
	 * @return
	 */
	public static Map<String, String> removeMyCarsList(String cardno) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "removeMyCarsList");
		map.put("cardno", cardno);
		return map;
	}

	/**
	 * 获取用户信息
	 * 
	 * @return
	 */
	public static Map<String, String> getUserInfo() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getUserInfo");
		return map;
	}

	/**
	 * 获取车长
	 * 
	 * @return
	 */
	public static Map<String, String> getCarLength() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getCarLength");
		return map;
	}

	/**
	 * 设置车长
	 * 
	 * @param map
	 *            cc车长，cc1起始车长，cc2结束车长
	 * @return
	 */
	public static Map<String, String> setCarLength(Map<String, String> map) {
		map.put("cmd", "setCarLength");
		return map;
	}

	/**
	 * 增加常跑路线
	 * 
	 * @param map
	 *            sfd 始发地编码，mdd目的地编码
	 * @return
	 */
	public static Map<String, String> addUsedLine(Map<String, String> map) {
		map.put("cmd", "addUsedLine");
		return map;
	}

	/**
	 * 删除常跑路线
	 * 
	 * @param map
	 *            sfd 始发地编码，mdd目的地编码
	 * @return
	 */
	public static Map<String, String> removeUsedLine(Map<String, String> map) {
		map.put("cmd", "removeUsedLine");
		return map;
	}

	/**
	 * 收听长跑路线
	 * 
	 * @see #unsubUsedLine(Map)
	 * @param map
	 *            sfd 始发地编码， mdd目的地编码
	 * @return
	 */
	public static Map<String, String> subUsedLine(Map<String, String> map) {
		map.put("cmd", "subUsedLine");
		return map;
	}

	/**
	 * 取消收听路线
	 * 
	 * @see #subUsedLine(Map)
	 * @param map
	 *            sfd 始发地便秘， mdd目的地编码
	 * @return
	 */
	public static Map<String, String> unsubUsedLine(Map<String, String> map) {
		map.put("cmd", "unsubUsedLine");
		return map;
	}

	/**
	 * 修改密码
	 * 
	 * @param map
	 *            mm新密码，yzm短信验证码
	 * @return
	 */
	public static Map<String, String> updatePassword(Map<String, String> map) {
		map.put("cmd", "updatePassword");
		return map;
	}

	/**
	 * 获取账户信息
	 * 
	 * @return
	 */
	public static Map<String, String> getUserAccount() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getUserAccount");
		return map;
	}

	/**
	 * 更新位置信息
	 * 
	 * @param map
	 *            jd经度，wd纬度
	 * @return
	 */
	public static Map<String, String> updateLocInfo(Map<String, String> map) {
		map.put("cmd", "updateLocInfo");
		return map;
	}

	/**
	 * 心跳包
	 * 
	 * @return
	 */
	public static Map<String, String> checkOnline() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "checkOnline");
		return map;
	}

	/**
	 * 指定承运人
	 * 
	 * @param map
	 *            hyid 货源ID,xxf 信息费,yf 运费，dsf 放空费,sqsm 申请说明
	 * @return
	 */
	public static Map<String, String> provideTheCarrier(Map<String, String> map) {
		map.put("cmd", "provideTheCarrier");
		return map;

	}

	/**
	 * 获取收藏列表
	 * 
	 * @return
	 */
	public static Map<String, String> getFavoritesList() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getFavoritesList");
		return map;
	}

	/**
	 * 添加收藏
	 * 
	 * @param hyid
	 *            货源ID
	 * @return
	 */
	public static Map<String, String> addFavorites(String hyid) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "addFavorites");
		map.put("hyid", hyid);
		return map;
	}

	/**
	 * 取消收藏
	 * 
	 * @param hyid
	 *            货源ID
	 * @return
	 */
	public static Map<String, String> removeFavorites(String hyid) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "removeFavorites");
		map.put("hyid", hyid);
		return map;
	}

	/**
	 * 申请交易 hyid:货源id sjhm:交易对象手机号 xxf:信息费 yf:运费 dsf:空驶费 sqsm:申请说明
	 * 
	 * @param map
	 * @return
	 */
	public static Map<String, String> applicationTransaction(
			Map<String, String> map) {
		map.put("cmd", "applicationTransaction");
		return map;
	}

	/**
	 * 同意交易
	 * 
	 * @param id
	 *            流水ID
	 * @param hyid
	 *            货源ID
	 * @return
	 */
	public static Map<String, String> agreeTransaction(String id, String hyid) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "agreeTransaction");
		map.put("id", id);
		map.put("hyid", hyid);
		return map;
	}

	/**
	 * 拒绝交易
	 * 
	 * @param id
	 *            流水ID
	 * @param hyid
	 *            货源ID
	 * @return
	 */
	public static Map<String, String> disagreeTransaction(String id, String hyid) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "disagreeTransaction");
		map.put("id", id);
		map.put("hyid", hyid);
		return map;
	}

	/**
	 * 撤销交易
	 * 
	 * @param id
	 *            流水ID
	 * @return
	 */
	public static Map<String, String> removeTransaction(String id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "removeTransaction");
		map.put("id", id);
		return map;
	}

	/**
	 * 我的申请
	 * 
	 * @return
	 */
	public static Map<String, String> getMyAgree() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getMyAgree");
		return map;
	}

	/**
	 * 向我申请
	 * 
	 * @return
	 */
	public static Map<String, String> getAgreeToMe() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getAgreeToMe");
		return map;
	}

	/**
	 * 评价列表
	 * 
	 * @return
	 */
	public static Map<String, String> getToEvaluation() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getToEvaluation");
		return map;
	}

	/**
	 * 我的交易记录
	 * 
	 * @return
	 */
	public static Map<String, String> getTransactionList() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getTransactionList");
		return map;
	}

	/**
	 * 交易评价
	 * 
	 * @return
	 */
	public static Map<String, String> evaluationTransaction(
			Map<String, String> map) {
		map.put("cmd", "evaluationTransaction");
		return map;
	}

	/**
	 * 获取会员信息
	 * 
	 * @param sjhm
	 * @return
	 */
	public static Map<String, String> getMemberInfo(String sjhm) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getMemberInfo");
		map.put("sjhm", sjhm);
		return map;
	}

	/**
	 * 获取诚信记录
	 * 
	 * @param sjhm
	 * @return
	 */
	public static Map<String, String> getEvaluationList(String sjhm) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getEvaluationList");
		map.put("sjhm", sjhm);
		return map;
	}

	/**
	 * 未读消息提示
	 * 
	 * @return
	 */
	public static Map<String, String> getMyBusiness() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getMyBusiness");
		return map;
	}

	/**
	 * 未读消息提示
	 * 
	 * @return
	 */
	public static Map<String, String> getInfoNumber() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getInfoNumber");
		return map;
	}

	/**
	 * 获取图片
	 * 
	 * @param sjhm
	 *            手机号码
	 * @param type
	 *            图片类型
	 * @return
	 */
	public static Map<String, String> getImage(String sjhm, String type) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getImage");
		map.put("sjhm", sjhm);
		map.put("type", type);
		return map;
	}

	/**
	 * 更新用户信息
	 * 
	 * @param map
	 * @return
	 */
	public static Map<String, String> setUserInfo(Map<String, String> map) {
		map.put("cmd", "setUserInfo");
		return map;
	}

	/**
	 * 支付完成后通知服务器
	 * 
	 * @param map
	 * @return
	 */
	public static Map<String, String> pay(Map<String, String> map) {
		map.put("cmd", "pay");
		return map;
	}

	public static Map<String, String> getPayItem() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getPayItem");
		return map;
	}

	/**
	 * 邀请码
	 * 
	 * @param map
	 * @return
	 */
	public static Map<String, String> setInvitedCode(Map<String, String> map) {
		map.put("cmd", "setInvitedCode");
		return map;
	}

	/**
	 * 我的发布记录
	 * 
	 * @param map
	 * @return
	 */
	public static Map<String, String> getMyReleased() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getMyReleased");
		return map;
	}

	/**
	 * 邀请码
	 * 
	 * @param map
	 * @return
	 */
	public static Map<String, String> AdClicked(String site) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "adClicked");
		map.put("site", site);
		return map;
	}

	/**
	 * 获取首页广告
	 * 
	 * @param map
	 * @return
	 */
	public static Map<String, String> AdHomePage() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "adHomePage");
		return map;
	}

	/**
	 * 物流黄页上传
	 */
	public static Map<String, Object> AddLogistics(Map<String, Object> map) {
		map.put("cmd", "addLogistics");
		return map;
	}

	/**
	 * 物流黄页
	 */
	public static Map<String, Object> GetLogistics(String lx1, String lx2) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cmd", "getLogistics");
		map.put("lx1", lx1);
		map.put("lx2", lx2);
		return map;
	}

	public static Map<String, Object> GetAd() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cmd", "getAd");
		return map;
	}

	public static Map<String, Object> getConmponent() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cmd", "getConmponent");
		return map;

	}

	/**
	 * 查看车辆详情
	 * 
	 * @param map
	 * @return
	 */
	public static Map<String, String> ReadCarsContact(String cyid) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "readCarsContact");
		map.put("cyid", cyid);
		return map;
	}

	/**
	 * 删除车源信息
	 * 
	 * @param map
	 * @return
	 */
	public static Map<String, String> DeleteCarsInfo(String cyid) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "deleteCarsInfo");
		map.put("cyid", cyid);
		return map;
	}

	/**
	 * 设置车辆状态，0空载，1满载
	 * 
	 * @param clzt
	 * @return
	 */
	public static Map<String, String> setCarStatus(String clzt, String cyid) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "setCarStatus");
		map.put("cyid", cyid);
		map.put("clzt", clzt);
		return map;
	}

	/**
	 * 发布车源信息
	 * 
	 * @param map
	 *            发布的消息封装在Map里，从UI获取
	 * @return
	 */
	public static Map<String, String> AddCarsInfo(Map<String, String> map) {
		map.put("cmd", "addCarsInfo");
		return map;
	}

	/**
	 * 获取最新版本
	 * */
	public static Map<String, String> getVersion() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getVersion");
		return map;
	}

	public static Map<String, String> getCardXfTodo() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getCardXfTodo");
		return map;
	}

	public static Map<String, String> getCardinfo() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getCardinfo");
		return map;
	}

	public static Map<String, String> getCardXfList() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getCardXfList");
		return map;
	}

	public static Map<String, Object> getCpflList() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cmd", "getCpflList");
		return map;
	}

	public static Map<String, String> agreeCardPay(Map<String, String> map) {
		map.put("cmd", "agreeCardPay");
		return map;
	}

	public static Map<String, String> cancelCardPay(Map<String, String> map) {
		map.put("cmd", "cancelCardPay");
		return map;
	}

	public static Map<String, Object> getDscpList(String flbh, int flbz) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cmd", "getDscpList");
		map.put("flbh", flbh);
		map.put("flbz", flbz);
		return map;
	}

	public static Map<String, Object> getDscpInfo(int cpbh) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cmd", "getDscpInfo");
		map.put("cpbh", cpbh);
		return map;
	}

	// 商城提交订单
	public static Map<String, Object> addReserve(int cpbh, String qssj,
			String jssj, String ydrxm, String ydrsjh, String ydrsfzh,
			String ydrcph, String mjbh, String yzm, String sl, String dw,
			String je, String thdzbh, int flbz) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cmd", "addReserve");
		map.put("cpbh", cpbh);
		map.put("qssj", qssj);
		map.put("jssj", jssj);
		map.put("ydrxm", ydrxm);
		map.put("ydrsjh", ydrsjh);
		map.put("ydrsfzh", ydrsfzh);
		map.put("ydrcph", ydrcph);
		map.put("mjbh", mjbh);
		map.put("yzm", yzm);
		map.put("sl", sl);
		map.put("dw", dw);
		map.put("je", je);
		map.put("thdzbh", thdzbh);
		map.put("flbz", flbz);
		return map;
	}

	// 商城我的订单
	public static Map<String, Object> getMyDsddInfo(String ddzt) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cmd", "getMyDsddInfo");
		map.put("ddzt", ddzt);
		return map;
	}

	/**
	 * 商城支付宝在线支付
	 * 
	 * @return
	 */
	public static Map<String, String> alipayCp(Map<String, String> map) {
		map.put("cmd", "alipayCp");
		return map;
	}

	/**
	 * 商城取消订单
	 * 
	 * @return
	 */
	public static Map<String, Object> cancelCp(Map<String, Object> map) {
		map.put("cmd", "cancelCp");
		return map;
	}

	/**
	 * 商城删除订单
	 * 
	 * @return
	 */
	public static Map<String, Object> deleteReserve(String ddbh) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cmd", "deleteReserve");
		map.put("ddbh", ddbh);
		return map;
	}

	/**
	 * 商城首页
	 * 
	 * @return
	 */
	public static Map<String, Object> getShoppingList() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cmd", "getShoppingList");
		return map;
	}

	// 从服务器获取地址编码信息
	public static Map<String, String> getCityList(String preCode, String type) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getCityList");
		map.put("preCode", preCode);
		map.put("type", type);

		Log.e("wkh_map", map.toString());
		return map;
	}

	// 从服务器获取地址编码信息
	public static Map<String, String> getCityList(String preCode, String type,
			String content) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getCityList");
		map.put("preCode", preCode);
		map.put("type", type);
		map.put("content", content);
		return map;
	}

	/**
	 * 获取通话记录列表
	 * 
	 * @return
	 */

	public static Map<String, String> getIPhoneList() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getIPhoneList");
		return map;
	}

	/**
	 * 拨打电话是添加通话记录
	 * 
	 * @return
	 */

	public static Map<String, String> addIPhoneRecord(String lxdh, String hyid,
			String sfd, String mdd) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "addIPhoneRecord");
		map.put("lxdh", lxdh);
		map.put("hyid", hyid);
		map.put("sfd", sfd);
		map.put("mdd", mdd);
		return map;
	}

	// 从服务器获取地址编码信息
	public static Map<String, String> getHomeList() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getHomeList");
		return map;
	}

	// 从服务器获取地址编码信息
	public static Map<String, String> getDtInfo(String dtbh) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "getdtinfo");
		map.put("dtbh", dtbh);
		return map;
	}

	public static Map<String, String> logout() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmd", "logout");
		return map;
	}

}
