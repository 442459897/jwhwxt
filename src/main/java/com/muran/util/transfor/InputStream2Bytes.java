package com.muran.util.transfor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class InputStream2Bytes {
	// 将InputStream转换成byte数组  
    public static byte[] inputStream2Bytes(InputStream in) throws IOException {  
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        byte[] data = new byte[512];  
        int count = -1;  
        while ((count = in.read(data, 0, 512)) != -1)  
            outStream.write(data, 0, count);  
        data = null;  
        return outStream.toByteArray();  
    } 
    public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "5+5=20";
		String st22 = new String(str.getBytes("utf-8"));
		System.out.println(st22);
	}
}
