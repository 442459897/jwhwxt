package com.muran.aop.annotation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.muran.application.GlobalConfig;
import com.muran.dao.IUserTokenDao;
import com.muran.model.UserToken;
import com.muran.util.MD5;

/**
 * 
 * @author Steven 2015年6月13日  用户操作日志处理类
 *
 */
public class UserSecurityVerify {
	private static final Logger log = Logger.getLogger(UserSecurityVerify.class);
	
	@Autowired
	private IUserTokenDao userTokenDao;
	
	
	public boolean verify(String url,String userToken,String timeStamp,String data,String signcode){
		log.info("userSecurityVerify:　"+userToken+"  "+timeStamp+"  "+data+"  "+url+"  "+signcode);
		if(GlobalConfig.getInstance().getConfig("debug").equalsIgnoreCase("true")||GlobalConfig.getInstance().getConfig("debug").equals(""))return true;
//		AssertNull.assertNull(url,userToken,timeStamp,signcode);
		UserToken token = userTokenDao.getUserTokenByToken(userToken);
		log.info("tokenSecret==null? 　"+(token==null));
		if(token!=null){
			StringBuffer sb = new StringBuffer();
			sb.append(userToken);
			sb.append(timeStamp);
			if(data!=null)sb.append(data);
			sb.append(url);
			sb.append(token.getTokenSecret());
			String serverSignCode = MD5.MD5(sb.toString());
			log.info("client signCode: "+signcode+"    server signCode origral : "+sb.toString()+" MD5："+serverSignCode);
			return signcode.equalsIgnoreCase(serverSignCode);
		}
		return false;
	}
	
	public boolean verify(String userToken){
		UserToken token = userTokenDao.getUserTokenByToken(userToken);
		if (token!=null&&token.isEnable()) {
			return true;
		}
		return false;
	}
}
