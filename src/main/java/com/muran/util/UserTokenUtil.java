package com.muran.util;

import com.muran.api.exception.GeneralResponseCode;
import com.muran.api.exception.ServerException;



public class UserTokenUtil {
	public static String getUserName(String token){
		try {
			String str[] = token.split("_");
			return str[0];
		} catch (Exception e) {
			// TODO: handle exception
			new ServerException(GeneralResponseCode.UserTokenException);
		}
		return null;
	}
}
