package com.android.line.view;

import android.app.Activity;
import android.view.View;

import com.android.line.R;
import com.android.line.view.CustomBar.CBOnClickListener;
/**
 * 请在UI布局中设置Id为bar，否则运行时会抛异常，异常信息为"请设置UI中CustomBar的ID为bar"。</p>
 * 请在跟布局中加入命名空间 xmlns:custom="http://schemas.android.com/apk/res/com.hongbao56.android"</p>
 * 这是一个CustomBar帮助类，简单封装了CustomBar的操作，
 * 只要在相应的地方如，activity，实例化这个类，便自动关联了view中的CustomBar</p>
 * {@link #setTitle(String)} 设置主题</p>
 * {@link OnClickListener} 是{@link CustomBar CBOnClickListener}的默认实现类，封装了左右Button的操作，
 * 
 * @author by 崔明强  at 2014年9月20日
 *
 */
public class CBarView {
	private CustomBar mBar = null;

	/**
	 * 构造函数，传入所属的Activity
	 * @param activity
	 * @param listener 如果为NULL ，由CBarController默认处理Bar的点击事件,即finish()当前Activity
	 * @see #CBarView(View, OnClickListener)
	 *
	 */
	public CBarView(final Activity activity, OnClickListener listener) {
		mBar = (CustomBar) activity.findViewById(R.id.bar);
		checkHasBar();
		if (listener == null) {
			mBar.setOnClickListener(new OnClickListener(){
				@Override
				public void onLeftClick() {
					activity.finish();
				}
			});
		} else {
			mBar.setOnClickListener(listener);
		}
	}
	/**
	 * 构造函数，传入所属的View，该View要包含CustomBar的控件
	 * @see #CBarView(Activity, OnClickListener)
	 * @param view
	 * @param listener
	 */
	public CBarView(View view, OnClickListener listener) {
		mBar = (CustomBar) view.findViewById(R.id.bar);
		checkHasBar();
		if (listener != null)
			mBar.setOnClickListener(listener);
	}
	/**
	 * 设置Bar显示的主题
	 * @param title
	 */
	public void setTitle(String title){
		mBar.setTitle(title);
	}
	/**
	 * 检查是否找到id为bar的bar
	 * 如果为null抛出异常
	 */
	private void checkHasBar(){
		if(mBar==null){
			throw new RuntimeException("请设置UI中CustomBar的ID为bar");
		}
	}

	/**
	 * 默认实现类
	 * @author by 崔明强  at 2014年9月25日
	 *
	 */
	public static class OnClickListener implements CBOnClickListener{
		/**
		 * 左边Button的响应事件
		 */
		@Override
		public void onLeftClick() {
			
		}
		/**
		 * 右边Button的响应事件
		 */
		@Override
		public void onRightClick() {
			
		}
	}
	/**
	 * 设置右边的Button是否显示
	 * @param visiblity
	 */
	public void setRightVisible(int visibility){
		mBar.setRightVisible(visibility);
	}	
	/**
	 * 设置右边Button的文本
	 * @param name
	 */
	public void setRightText(String name){
		mBar.setRightText(name);
	}
	/**
	 * 设置左边的Button是否显示
	 * @param visibility
	 */
	public void setLeftVisible(int visibility){
		mBar.setLeftVisible(visibility);
	}
	/**
	 * 设置左边Button的文本
	 * @param name
	 */
	public void setLeftText(String name){
		mBar.setLeftText(name);
	}
}
