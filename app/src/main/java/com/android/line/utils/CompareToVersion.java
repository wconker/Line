package com.android.line.utils;

import java.util.ArrayList;

import android.util.Log;

public class CompareToVersion {

	private ArrayList<Integer> onlineVersion = new ArrayList<Integer>();
	private ArrayList<Integer> localVersion = new ArrayList<Integer>();

	public boolean compareToVersion(String onlineString, String localString) {

		onlineVersion = split(replaceString(onlineString));
		localVersion = split(localString);
		if (onlineVersion.size() > localVersion.size()) {
			int i = 0;
			for (; i < localVersion.size(); i++) {
				if (onlineVersion.get(i) > localVersion.get(i)) {
					return true;
				} else if (onlineVersion.get(i) < localVersion.get(i)) {
					return false;
				}
			}
			if (i == localVersion.size()) {
				return true;
			}
		} else {
			for (int i = 0; i < onlineVersion.size(); i++) {
				if (onlineVersion.get(i) > localVersion.get(i)) {
					return true;
				} else if (onlineVersion.get(i) < localVersion.get(i)) {
					return false;
				}
			}
		}

		return false;

	}

	private ArrayList<Integer> split(String str) {
		ArrayList<Integer> strVersion = new ArrayList<Integer>();
		String[] sourceStrArray = str.split("[.]");
		for (int i = 0; i < sourceStrArray.length; i++) {
			strVersion.add(Integer.parseInt(sourceStrArray[i]));
		}
		return strVersion;
	}

	private String replaceString(String str) {
		return str.replace("1-", "");

	}
}
