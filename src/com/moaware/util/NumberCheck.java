package com.moaware.util;

public class NumberCheck {

	public static int nullToZero(String tmp) {
		int num = 0;
		if(isNumber(tmp))
			num = Integer.parseInt(tmp);
		return num;
	}
	
	public static int nullToOne(String tmp) {
		int num = 1;
		if(isNumber(tmp))
			num = Integer.parseInt(tmp);
		return num;
	}

	private static boolean isNumber(String tmp) {
		boolean flag = true;
		if(tmp != null && !tmp.isEmpty()) {
			int len = tmp.length();
			for(int i = 0; i < len; i++) {
				int ascii = tmp.charAt(i);
				if(ascii < 48 || ascii > 58) {
					flag = false;
					break;
				}
			}
		} else {
			flag = false;
		}
		return flag;
	}
}
