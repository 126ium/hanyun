package com.hanyun.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
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
	 * Convert byte to Hex string
	 * @param in byteArray data
	 * @return Hex string
	 */
	public static String byteToHex(byte[] in) {
		StringBuffer buf = new StringBuffer();
		for (int offset = 0; offset < in.length; offset++) {
			int i;
			i = in[offset];
			if (i < 0)
				i += 256;
			if (i < 16)
				buf.append("0");
			buf.append(Integer.toHexString(i));
		}
		
		return buf.toString().toUpperCase();
	}
	
	/**
	 * MD5 加密
	 * @param plainText 带加密文本
	 * @return String 加密后的字符串
	 */
	public String MD5(String plainText) {
		String result = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes("UTF-8"));
			result = byteToHex(md.digest());		
		} catch (NoSuchAlgorithmException e) {
			LogUtil.log("WARNING", e.toString());
			e.printStackTrace();
		} catch (UnsupportedEncodingException e2) {
			LogUtil.log("WARNING", e2.toString());
			e2.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Encode a file to MD5 hash code
	 * @param data A file
	 * @return String Hex string
	 */
	public static String MD5(File data) {
		String result = null;
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			FileInputStream inStream = new FileInputStream(data);
			FileChannel channel = inStream.getChannel();
			int length = (int) channel.size();
			MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, length);
			channel.close();
			inStream.close();
			md.update(buffer);
			result = byteToHex(md.digest());
		} catch (NoSuchAlgorithmException e) {
			LogUtil.log("WARNING", e.toString());
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			LogUtil.log("WARNING", e.toString());
			e.printStackTrace();
		} catch (IOException e) {
			LogUtil.log("WARNING", e.toString());
			e.printStackTrace();
		}
		
		return result;
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
		
		File testFile = new File("/home/ezio/test_fs");
		System.out.println(MD5(testFile));
	}
}