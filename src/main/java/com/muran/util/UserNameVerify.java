package com.muran.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class UserNameVerify implements IDataVerify {
	//以字母开头的4-15个字符组成
	private static final String regular = "^[a-zA-Z][a-zA-Z0-9]{3,15}$";
	private static UserNameVerify instance;
	
	private UserNameVerify(){}
	
	public synchronized static UserNameVerify getInstance(){
		if(instance==null) instance= new UserNameVerify();
		return instance;
	}
	@Override
	public boolean verify(String str) {
		  Pattern p = null;  
	        Matcher m = null;  
	        boolean b = false;   
	        p = Pattern.compile(regular); // 验证手机号  
	        m = p.matcher(str);  
	        b = m.matches();
	        return b;  
	}

}
