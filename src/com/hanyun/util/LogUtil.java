package com.hanyun.util;

import org.apache.log4j.Logger;

public class LogUtil {
	static Logger log = Logger.getLogger(LogUtil.class.getName());
	public static void log(String level, String msg) {
//		System.out.println(level + "  " + msg);
		log.info(level + "   "  + msg);
	}
}
