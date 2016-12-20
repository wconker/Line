package com.android.line.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;

//用来从网络上获取图片的一个类，通过setimage方法来获取图片
public class PullImage {

	Bitmap bitmap = null;
	ImageView mImage = null; // 用来显示图片的控件
	String path; // 图片的网络路径
	InputStream is = null; // 浏
	RelativeLayout rel_progress = null;
	RelativeLayout rel_nodata = null;

	// 定义一个带两个参数的构造方法 、分别为显示图片的控件、图片的网络路径
	public PullImage(ImageView mImage, String path) {
		this.mImage = mImage;
		this.path = path;
	}

	public PullImage(ImageView mImage, String path,
			RelativeLayout rel_progress, RelativeLayout rel_nodata) {
		this.mImage = mImage;
		this.path = path;
		this.rel_progress = rel_progress;
		this.rel_nodata = rel_nodata;
	}

	// 获取图片的方法
	public Bitmap SetImage() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					URL url = new URL(path);
					is = url.openStream();
					bitmap = BitmapFactory.decodeStream(is);
					// 通过调用hander在图片控件上显示图片
					handler.sendEmptyMessage(2);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (is != null) {
						try {
							is.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}).start();
		return bitmap;
	}

	@SuppressLint("HandlerLeak")
	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			mImage.setImageBitmap(bitmap);
			super.handleMessage(msg);
		}
	};
}
