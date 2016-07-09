<%@page import="com.muran.application.GlobalConfig"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>创建微信公众号菜单</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<%
		String createUrl = java.net.URLEncoder.encode(
				GlobalConfig.KEY_WEB_BASE + "createMenu2.jsp", "utf-8");
		String oath2url = GlobalConfig.KEY_WEB_BASE
				+ "api/oauth2?type=url&uri=" + createUrl;
	%>
	<div style="width:100%;text-align:center;">
		<a href="<%=oath2url%>" style="font-size:50px;">创建微信菜单</a>
	</div>

</body>
</html>
