package com.android.line.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.line.R;


/**
 * 自定义bar控件， 共有7个属性， 分别设置左右Button的文本，背景，可见性， 一个设置title
 * 参见values文件夹中attrs中custom_bar定义的属性, 案例参见activity_register中
 * 
 * 也请看看CBarView，其封装了CustomBar的相关功能
 * 
 * @author by 崔明强 at 2014年9月19日
 * 
 */
public class CustomBar extends RelativeLayout implements OnClickListener {
	private Button mLeft;
	private Button mRight;
	private TextView mTitle;
	private TextView mTop;
	private CBOnClickListener mListener;

	public CustomBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(getContext()).inflate(R.layout.view_common_bar,
				this);
		mLeft = (Button) findViewById(R.id.left);
		mRight = (Button) findViewById(R.id.right);
		mTitle = (TextView) findViewById(R.id.title);
		mTop = (TextView) findViewById(R.id.top);

		// if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
		// mTop.setVisibility(View.VISIBLE);
		// } else {
		// mTop.setVisibility(View.GONE);
		// }

		TypedArray array = context.obtainStyledAttributes(attrs,
				R.styleable.custom_bar);
		if (array != null) {
			for (int i = 0; i < array.getIndexCount(); i++) {
				int id = array.getIndex(i);
				switch (id) {
				case R.styleable.custom_bar_left_name:
					String leftname = array.getString(id);
					mLeft.setText(leftname);
					break;
				case R.styleable.custom_bar_left_img:
					int leftid = array.getResourceId(id, 100);
					mLeft.setBackgroundResource(leftid);
					break;
				case R.styleable.custom_bar_left_visible:
					int leftvisible = array.getInteger(id, 0);
					mLeft.setVisibility(leftvisible);
					break;
				case R.styleable.custom_bar_right_name:
					String rightname = array.getString(id);
					mRight.setText(rightname);
					break;
				case R.styleable.custom_bar_right_img:
					int rightid = array.getResourceId(id, 100);
					mRight.setBackgroundResource(rightid);
					break;
				case R.styleable.custom_bar_right_visible:
					int rightvisible = array.getInteger(id, 0);
					mRight.setVisibility(rightvisible);
					break;
				case R.styleable.custom_bar_titlename:
					String title = array.getString(id);
					mTitle.setText(title);
					break;
				default:
					break;
				}
			}
		}
		array.recycle();
	}

	/**
	 * 注册一个监听器，监听左右Button的点击事件
	 * 
	 * @param listener
	 */
	public void setOnClickListener(CBOnClickListener listener) {
		mLeft.setOnClickListener(this);
		mRight.setOnClickListener(this);
		mListener = listener;
	}

	/**
	 * 设置显示的标题
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		mTitle.setText(title);
	}

	/**
	 * 设置右边的Button是否显示
	 * 
	 * @param visiblity
	 */
	public void setRightVisible(int visibility) {
		mRight.setVisibility(visibility);
	}

	/**
	 * 设置头部的空间是否显示
	 * 
	 * @param visiblity
	 */
	public void setTopVisible(int visibility) {
		mTop.setVisibility(visibility);
	}

	/**
	 * 设置右边Button的文本
	 * 
	 * @param name
	 */
	public void setRightText(String name) {
		mRight.setText(name);
	}

	/**
	 * 设置左边的Button是否显示
	 * 
	 * @param visibility
	 */
	public void setLeftVisible(int visibility) {
		mLeft.setVisibility(visibility);
	}

	/**
	 * 设置左边Button的文本
	 * 
	 * @param name
	 */
	public void setLeftText(String name) {
		mLeft.setText(name);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.left:
			if (mListener != null) {
				mListener.onLeftClick();
			}
			break;
		case R.id.right:
			if (mListener != null) {
				mListener.onRightClick();
			}
			break;
		default:
			break;
		}

	}

	public interface CBOnClickListener {
		/**
		 * 当左边的按钮被点击时
		 */
		void onLeftClick();

		/**
		 * 右边的按钮被点击时
		 */
		void onRightClick();
	}
}
