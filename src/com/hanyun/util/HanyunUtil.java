package com.hanyun.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * 汉云 工具类
 * @author IntSilence 2013-9-18 21:28:14
 * @version 1.0
 *
 */
public class HanyunUtil {
	private static HanyunUtil instance = new HanyunUtil();
	
	private HanyunUtil() {}
	
	// 单件模式
	public static HanyunUtil getInstance() {
		return instance;
	}
	
	/**
	 * MD5 加密
	 * @param plainText 带加密文本
	 * @return String 加密后的字符串
	 */
	public String MD5(String plainText) {
		StringBuffer buf = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes("UTF-8"));
			byte b[] = md.digest();
			int i;
			// byte array 转字符串
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
		}
		
		return buf.toString().toUpperCase();
	}
	
	/**
	 * 获取salt，随机的八位字母、数字组合
	 * @return 随机的salt
	 */
	public String getSalt() {
		char[] alphabet = ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
		StringBuilder buf = new StringBuilder();
		Random rand = new Random();
		for (int i = 0; i < 8 ; i ++) {
			buf.append(alphabet[rand.nextInt(36)]);
		}
		
		return buf.toString();
	}
	
	// test
	public static void main(String...args) {
		System.out.println(instance.MD5("intsilence"));
		System.out.println(instance.getSalt());
		System.out.println(instance.MD5(instance.MD5("intsilence") + instance.getSalt()));
	}
}