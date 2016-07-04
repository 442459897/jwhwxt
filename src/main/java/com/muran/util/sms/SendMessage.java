package com.muran.util.sms;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 短信发送
 * 
 * @author 郑金龙 日期：2015-8-6
 */
public class SendMessage {

//	private static Logger log = Logger.getLogger(SendMessage.class);

	private static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

	/**
	 * 异步发送
	 * 
	 * @param mobile
	 * @param content
	 */
	public static void sendOneMessageAsyn(final String mobile, final String content) {
		// TODO Auto-generated method stub
		cachedThreadPool.execute(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				sendOneMessage(mobile, content);
			}
		});
	}


	/**
	 * 单条短信发送 0 提交成功 1 含有敏感词汇 2 余额不足 3 没有号码 4 包含sql语句 10 账号不存在 11 账号注销 12 账号停用
	 * 13 IP鉴权失败 14 格式错误 -1 系统异常
	 * 
	 * @param content
	 * @param mobile
	 * 
	 */
	public static String sendOneMessage(String mobile, String content) {
		System.out.println("发送手机验证码: "+mobile + "  "+content);
		String sign = "幕然科技";
		// 创建StringBuffer对象用来操作字符串
		StringBuffer sBuffer = new StringBuffer("http://web.duanxinwang.cc/asmx/smsservice.aspx?");
		sBuffer.append("name=18137796928");
		sBuffer.append("&pwd=30692D236F23CF7F70ACE938D844");
		// 向StringBuffer追加手机号码
		sBuffer.append("&mobile=" + mobile);
		// 向StringBuffer追加消息内容转URL标准码
		try {
			sBuffer.append("&content=" + URLEncoder.encode(content, "UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// 追加发送时间，可为空，为空为及时发送
		sBuffer.append("&stime=");
		// 加签名
		try {
			sBuffer.append("&sign=" + URLEncoder.encode(sign, "UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// type为固定值pt extno为扩展码，必须为数字 可为空
		sBuffer.append("&type=pt&extno=");
		URL url = null;
		try {
			url = new URL(sBuffer.toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 打开url连接
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 设置url请求方式 ‘get’ 或者 ‘post’
		try {
			connection.setRequestMethod("POST");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 发送
		InputStream is = null;
		try {
			is = url.openStream();
			String returnStr = convertStreamToString(is);
			System.out.println("发送手机验证码("+mobile+") 返回信息: "+returnStr);
			return returnStr;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "99,发送短信请求失败";

	}


	/**
	 * 转换返回值类型为UTF-8格式.
	 * 
	 * @param is
	 * @return
	 */
	public static String convertStreamToString(InputStream is) {
		StringBuilder sb1 = new StringBuilder();
		byte[] bytes = new byte[4096];
		int size = 0;

		try {
			while ((size = is.read(bytes)) > 0) {
				String str = new String(bytes, 0, size, "UTF-8");
				sb1.append(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb1.toString();
	}

}
