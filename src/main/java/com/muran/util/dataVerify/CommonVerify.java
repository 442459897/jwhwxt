package com.muran.util.dataVerify;

import java.io.InputStream;
import java.net.URL;

public class CommonVerify {

	public static boolean verifyUrl(String url) {
		// TODO Auto-generated method stub
		URL urlobj;
		try {
			urlobj = new URL(url);
			InputStream in = urlobj.openStream();
			// System.out.println("连接可用");
			return true;
		} catch (Exception e1) {
			// System.out.println("连接打不开!");
			urlobj = null;
		}
		return false;
	}

}
