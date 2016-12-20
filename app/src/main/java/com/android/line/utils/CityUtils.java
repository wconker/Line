package com.android.line.utils;

public class CityUtils {

	public String getNowCityCode(String code) {

		if (code.length() != 6) {
			return "000000";
		}

		if (!code.substring(4, 6).equals("00")) {
			return code.substring(0, 4) + "00";
		}

		return code;

	}

	public String getLastCityCode(String code) {

		if (!code.substring(3, 6).equals("000")) {
			if (!code.substring(2, 6).equals("0000")) {
				return code.substring(0, 2) + "0000";
			} else {
				return code.substring(0, 3) + "000";
			}
		}

		if (code.substring(3, 6).equals("000") || code.length() != 6) {
			return "0";
		}

		return code;

	}
}
