package com.muran.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/**
	 * 时间戳转日期
	 * 
	 */
	public static Date timestampTransToDate(String timestamp) {
		if (timestamp == null || timestamp.equals(""))
			return null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long time = new Long(timestamp);
		String d = format.format(time);
		Date date = null;
		try {
			date = format.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 日期转换成字符串
	 * 
	 * @param date
	 * @return str
	 */
	public static String DateToStr(Date date) {

		if (date == null) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = format.format(date);
		return str;
	}

	/**
	 * 日期转年月字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String DateToString(Date date) {

		if (date == null) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String str = format.format(date);
		return str;
	}

	/**
	 * 字符串转换成日期(yyyy-MM-dd)
	 * 
	 * @param str
	 * @return date
	 */
	public static Date StrToDate(String str) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 字符串转换成日期(yyyy-MM)
	 * 
	 * @param str
	 * @return
	 */
	public static Date StringToDate(String str) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static boolean StringIsNull(String str) {
		if (str == null || str.equals("")) {
			return true;
		}
		return false;
	}

	/**
	 * 时间戳转换成日期字符串
	 * 
	 * @param timestamp
	 * @return
	 */
	public static String timestampToDateStr(String timestamp) {
		if (timestamp == null || timestamp.equals(""))
			return null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long time = new Long(timestamp);
		String d = format.format(time);
		Date date = null;
		try {
			date = format.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return DateToStr(date);
	}

	public static String getTrdBillNo(String trdCode) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String trdBillNo = trdCode + format.format(new Date())
				+ createRandom(true, 4);
		return trdBillNo;

	}

	public static String createRandom(boolean numberFlag, int length) {
		String retStr = "";
		String strTable = numberFlag ? "1234567890"
				: "1234567890abcdefghijkmnpqrstuvwxyz";
		int len = strTable.length();
		boolean bDone = true;
		do {
			retStr = "";
			int count = 0;
			for (int i = 0; i < length; i++) {
				double dblR = Math.random() * len;
				int intR = (int) Math.floor(dblR);
				char c = strTable.charAt(intR);
				if (('0' <= c) && (c <= '9')) {
					count++;
				}
				retStr += strTable.charAt(intR);
			}
			if (count >= 2) {
				bDone = false;
			}
		} while (bDone);

		return retStr;
	}

}
