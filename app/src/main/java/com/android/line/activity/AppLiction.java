package com.android.line.activity;

import java.io.File;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LRULimitedMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.utils.StorageUtils;
import com.tencent.bugly.crashreport.CrashReport;

public class AppLiction extends Application {

	public static RequestQueue queue;

	@Override
	public void onCreate() {
		//SDKInitializer.initialize(this);
		ImageLoader.getInstance().init(getourmyconfig());
		queue = Volley.newRequestQueue(getApplicationContext());
		CrashReport
				.initCrashReport(getApplicationContext(), "900058443", false);
		super.onCreate();
	}

	public static RequestQueue getHttpQueue() {
		return queue;
	}

	private ImageLoaderConfiguration getourmyconfig() {
		// 设置缓存的路径
		File cacheDir = StorageUtils.getOwnCacheDirectory(
				getApplicationContext(), "imageloader/Cache");
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				getApplicationContext()).threadPoolSize(3)
				.threadPriority(Thread.NORM_PRIORITY - 2)
				// 线程池中线程的个数
				.tasksProcessingOrder(QueueProcessingType.LIFO)
				// 工作队列
				.denyCacheImageMultipleSizesInMemory()
				// 禁止缓存多张图片
				.memoryCache(new LRULimitedMemoryCache(10 * 1024 * 1024))
				// 缓存策略
				.diskCacheFileNameGenerator(new Md5FileNameGenerator()) // 缓存文件名的保存方式
				.diskCacheSize(150 * 1024 * 1024) // 磁盘缓存大小
				.diskCacheFileCount(200) // 缓存的文件数量
				.diskCache(new UnlimitedDiskCache(cacheDir)) // 自定义缓存路径
				.writeDebugLogs() // Remove for release app
				.build();
		return config;
	}

}
