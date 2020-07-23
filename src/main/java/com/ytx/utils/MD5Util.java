package com.ytx.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	
	/***
	 * MD5加码 生成32位md5码
	 * @throws Exception 
	 */
	public static String string2MD5(String inStr){
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}
		byte[] md5Bytes = md5.digest(inStr.getBytes());
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();

	}
	
	public static void main(String[] args) {
		System.out.println(MD5Util.string2MD5("123456"));
	}
	
}
