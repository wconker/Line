package com.android.line.utils;

import java.io.ByteArrayOutputStream;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;

import com.android.line.R;

/**
 * 图片辅助类 将图片转为Base64字符串 {@link #BitmapToString(Bitmap)} 将Base64字符串转为图片
 * {@link #stringToBitmap(String)}
 * 
 * @author cuimingqiang
 * 
 */
public class ImageUtil {
	public static String BitmapToString(Bitmap bitmap) {
		if (bitmap == null)
			return "";
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		bitmap.compress(CompressFormat.PNG, 100, arrayOutputStream);
		byte[] data = arrayOutputStream.toByteArray();
		return Base64.encodeToString(data, 0);
	}

	/**
	 * 
	 * @param data
	 *            存为字符串的图片
	 * @return
	 */
	public static Bitmap stringToBitmap(String data) {
		if (data == null)
			return null;
		byte[] s = Base64.decode(data.getBytes(), 0);
		Bitmap bitmap = BitmapFactory.decodeByteArray(s, 0, s.length);
		return bitmap;
	}

	/**
	 * 循环压缩
	 * 
	 * @param bitmap
	 * @return
	 */
	public static String BitmapToStringTwo(Bitmap bitmap) {
		if (bitmap == null)
			return "";
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		bitmap.compress(CompressFormat.JPEG, 100, arrayOutputStream);
		int options = 100;
		// 如果大于80kb则再次压缩,最多压缩三次
		while (arrayOutputStream.toByteArray().length / 1024 > 50
				&& options != 10) {
			// 清空baos
			arrayOutputStream.reset();
			// 这里压缩options%，把压缩后的数据存放到baos中
			bitmap.compress(CompressFormat.JPEG, options,
					arrayOutputStream);
			options -= 30;
		}
		byte[] data = arrayOutputStream.toByteArray();
		return Base64.encodeToString(data, Base64.DEFAULT);
	}

	public static boolean hasShortCut(Context context) {
		String url = "";
		System.out.println(getSystemVersion());
		if (getSystemVersion() < 8) {
			url = "content://com.android.launcher.settings/favorites?notify=true";
		} else {
			url = "content://com.android.launcher2.settings/favorites?notify=true";
		}
		ContentResolver resolver = context.getContentResolver();
		Cursor cursor = resolver.query(Uri.parse(url), null, "title=?",
				new String[] { context.getString(R.string.hot_name) }, null);

		if (cursor != null && cursor.moveToFirst()) {
			cursor.close();
			return true;
		}

		return false;
	}

	private static int getSystemVersion() {
		return android.os.Build.VERSION.SDK_INT;
	}
}
