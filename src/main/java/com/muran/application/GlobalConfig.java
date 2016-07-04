package com.muran.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.servlet.ServletContext;
import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;

public class GlobalConfig {
	/*
	  	debug=true
	 	qiniu_key=hYI5i25STq8lpV3LdWLKUS625DdpdoMhpInJrBvR
	 	qiniu_secret=Fzr3BHhK9rm7IAvwg8bNL2_jRB_2tG04YTU_hHvG
	 	qiniu_img_bucket=wxbox
	 	qiniu_html_buketname=mxhtml
	 */

	public static final String KEY_DEBUG = "debug";
	public static final String KEY_QINIU_KEY = "qiniu_key";
	public static final String KEY_QINIU_SECRET = "qiniu_secret";
	public static final String KEY_QINIU_BUCKET_IMG = "qiniu_img_bucket";
	public static final String KEY_QINIU_BUCKET_HTML = "qiniu_html_buketname";
	public static final String KEY_TEAM_AD_COVER = "team_ad_cover";
	public static final String KEY_TEAM_AD_TITLE = "team_ad_title";
	public static final String KEY_TEAM_AD_DESC = "team_ad_desc";
	public static final String KEY_TEAM_AD_LINKTYPE = "team_ad_linkType";
	public static final String KEY_TEAM_AD_LINK = "team_ad_link";
	public static final String KEY_TEAM_AD_TYPE = "team_ad_type";
	public static final String KEY_TEAM_AD_SUBTYPE = "team_ad_subType";



	private final static Logger log = Logger.getLogger(GlobalConfig.class);
	private final static String COMMON_CONFIG_FILE = "WEB-INF" + File.separator
			+ "classes" + File.separator + "common.properties";
	Properties pro = new Properties();

	private GlobalConfig(String configFileName) {
		try {
			pro.load(new FileInputStream(configFileName));
		} catch (Exception e) {
			log.error("未找到配置文件common.properties");
		}
	}
	private GlobalConfig(InputStream is) {
		try {
			pro.load(is);
		} catch (Exception e) {
			log.error("未找到配置文件common.properties");
		}
	}

	private static GlobalConfig instance;

	public synchronized static GlobalConfig getInstance(ServletContext context) {
		if (instance == null) {
			ClassPathResource comcrs = new ClassPathResource("common.properties");
			//String path = context.getRealPath(File.separator);//使用classpath获取文件
			log.info("配置文件地址:-->" + comcrs.getPath());
			try {
				log.info("配置文件地址:-->" + comcrs.getURL());
				//instance = new GlobalConfig(comcrs.getURL().toString());
				instance = new GlobalConfig(comcrs.getInputStream());
			} catch (IOException e) {
				log.error(e, e);
			}
		}
		if (instance == null) {
			String path = context.getRealPath(File.separator);
			instance = new GlobalConfig(path + File.separator
					+ COMMON_CONFIG_FILE);
		}
		return instance;
	}

	public synchronized static GlobalConfig getInstance() {
		if (instance == null) {
			throw new RuntimeException("程序启动时未初始化GlobalConfig");
		}
		return instance;
	}

	public String getConfig(String key) {
		return pro.getProperty(key,"");
	}

	

}
