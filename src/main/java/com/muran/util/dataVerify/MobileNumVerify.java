package com.muran.util.dataVerify;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileNumVerify implements IDataVerify {
	private static final String regular = "^[1][3,4,5,8,7][0-9]{9}$";
	private static MobileNumVerify instance;
	
	private MobileNumVerify(){}
	
	public synchronized static MobileNumVerify getInstance(){
		if(instance==null) instance= new MobileNumVerify();
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
