package com.android.line.utils;

import android.graphics.Bitmap;

import com.android.line.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;

public class Options {
	/**
	 * 图片加载配置
	 */
	public static DisplayImageOptions getListOptions() {
		DisplayImageOptions options = new DisplayImageOptions.Builder()
				// 设置图片在下载期间显示的图片
				.showImageOnLoading(R.drawable.app_ad)
				// 设置图片Uri为空或是错误的时候显示的图片
				.showImageForEmptyUri(R.drawable.app_ad)
				// 设置图片加载/解码过程中错误时候显示的图片
				.showImageOnFail(R.drawable.app_ad).cacheOnDisk(true)
				// 设置下载的图片是否缓存在内存中
				.cacheInMemory(true)
				// 设置图片以如何的编码方式显示
				.imageScaleType(ImageScaleType.NONE)
				// 设置图片的解码类型
				.bitmapConfig(Bitmap.Config.RGB_565)
				.displayer(new SimpleBitmapDisplayer()).build();
		return options;
	}


	/**
	 * 图片加载配置
	 */
	public static DisplayImageOptions getSHPagerOptions() {
		DisplayImageOptions options = new DisplayImageOptions.Builder()
				// 设置图片在下载期间显示的图片
				.showImageOnLoading(R.drawable.ic_launcher)
				// 设置图片Uri为空或是错误的时候显示的图片
				.showImageForEmptyUri(R.drawable.ic_launcher)
				// 设置图片加载/解码过程中错误时候显示的图片
				.showImageOnFail(R.drawable.ic_launcher).cacheOnDisk(true)
				// 设置下载的图片是否缓存在内存中
				.cacheInMemory(true)
				// 设置图片以如何的编码方式显示
				.imageScaleType(ImageScaleType.NONE)
				// 设置图片的解码类型
				.bitmapConfig(Bitmap.Config.RGB_565)
				.displayer(new SimpleBitmapDisplayer()).build();
		return options;
	}
	/**
	 * 图片加载配置
	 */
	public static DisplayImageOptions getYelloPagerOptions() {
		DisplayImageOptions options = new DisplayImageOptions.Builder()
				// 设置图片在下载期间显示的图片
				.showImageOnLoading(R.drawable.hy_bg)
				// 设置图片Uri为空或是错误的时候显示的图片
				.showImageForEmptyUri(R.drawable.hy_bg)
				// 设置图片加载/解码过程中错误时候显示的图片
				.showImageOnFail(R.drawable.hy_bg).cacheOnDisk(true)
				// 设置下载的图片是否缓存在内存中
				.cacheInMemory(true)
				// 设置图片以如何的编码方式显示
				.imageScaleType(ImageScaleType.NONE)
				// 设置图片的解码类型
				.bitmapConfig(Bitmap.Config.RGB_565)
				.displayer(new SimpleBitmapDisplayer()).build();
		return options;
	}

	/**
	 * 图片加载配置
	 */
	public static DisplayImageOptions getAppiconOptions() {
		DisplayImageOptions options = new DisplayImageOptions.Builder()
				// 设置图片在下载期间显示的图片
				.showImageOnLoading(R.drawable.join)
				// 设置图片Uri为空或是错误的时候显示的图片
				.showImageForEmptyUri(R.drawable.join)
				// 设置图片加载/解码过程中错误时候显示的图片
				.showImageOnFail(R.drawable.join).cacheOnDisk(true)
				// 设置下载的图片是否缓存在内存中
				.cacheInMemory(true)
				// 设置图片以如何的编码方式显示
				.imageScaleType(ImageScaleType.NONE)
				// 设置图片的解码类型
				.bitmapConfig(Bitmap.Config.RGB_565)
				.displayer(new SimpleBitmapDisplayer()).build();
		return options;
	}

	/**
	 * 图片加载配置
	 */
	public static DisplayImageOptions getProduct2Options() {
		DisplayImageOptions options = new DisplayImageOptions.Builder()
				// 设置图片在下载期间显示的图片
				.showImageOnLoading(R.drawable.gascard)
				// 设置图片Uri为空或是错误的时候显示的图片
				.showImageForEmptyUri(R.drawable.gascard)
				// 设置图片加载/解码过程中错误时候显示的图片
				.showImageOnFail(R.drawable.gascard).cacheOnDisk(true)
				// 设置下载的图片是否缓存在内存中
				.cacheInMemory(true)
				// 设置图片以如何的编码方式显示
				.imageScaleType(ImageScaleType.NONE)
				// 设置图片的解码类型
				.bitmapConfig(Bitmap.Config.RGB_565)
				.displayer(new SimpleBitmapDisplayer()).build();
		return options;
	}
}
