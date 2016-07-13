package com.muran.util;

import java.util.ArrayList;
import java.util.List;

import com.muran.dto.GeneralString;

public class CommonUtil {

	public static List<String> getByStrings(String str, String regex) {
		List<String> list = new ArrayList<String>();
		String[] array = str.split(regex);
		for (String string : array) {
			list.add(string);
		}
		return list;
	}

	public static List<GeneralString> getByStringSplit(String str, String regex) {
		List<GeneralString> list = new ArrayList<GeneralString>();
		String[] array = str.split(regex);
		for (String string : array) {
			GeneralString string2 = new GeneralString();
			string2.setValue(string);
			list.add(string2);
		}
		return list;
	}

	public static String getStringList(List<GeneralString> list) {
		String result = "";
		for (GeneralString string : list) {
			result += string.getValue() + ",";
		}
		result = result.substring(0, result.length() - 1);
		return result;
	}
}
