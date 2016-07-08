package com.muran.util;

import java.util.ArrayList;
import java.util.List;

public class WxConfigUtil {
	
	public static List<String> jsApiList = new ArrayList<String>();
	
	static {
		jsApiList.add("checkJsApi");
		jsApiList.add("onMenuShareTimeline");
		jsApiList.add("onMenuShareAppMessage");
		jsApiList.add("onMenuShareQQ");
		jsApiList.add("onMenuShareWeibo");
		jsApiList.add("hideMenuItems");
		jsApiList.add("showMenuItems");
		jsApiList.add("hideAllNonBaseMenuItem");
		jsApiList.add("showAllNonBaseMenuItem");
		jsApiList.add("translateVoice");
		jsApiList.add("startRecord");
		jsApiList.add("stopRecord");
		jsApiList.add("onRecordEnd");
		jsApiList.add("playVoice");
		jsApiList.add("pauseVoice");
		jsApiList.add("stopVoice");
		jsApiList.add("uploadVoice");
		jsApiList.add("downloadVoice");
		jsApiList.add("chooseImage");
		jsApiList.add("previewImage");
		jsApiList.add("uploadImage");
		jsApiList.add("downloadImage");
		jsApiList.add("getNetworkType");
		jsApiList.add("openLocation");
		jsApiList.add("getLocation");
		jsApiList.add("hideOptionMenu");
		jsApiList.add("showOptionMenu");
		jsApiList.add("closeWindow");
		jsApiList.add("scanQRCode");
		jsApiList.add("chooseWXPay");
		jsApiList.add("openProductSpecificView");
		jsApiList.add("addCard");
		jsApiList.add("chooseCard");
		jsApiList.add("openCard");
	}
}
