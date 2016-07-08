package com.muran.api.exception;
public class AssertNull {
	public static void assertNull(Object ...args){
		for(Object object :args){
			if(object==null) throw new ServerException(GeneralResponseCode.BadRequestParams);
		}
	}
}
