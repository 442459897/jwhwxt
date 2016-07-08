<%@page import="com.muran.api.exception.Code"%>
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
<title>系统错误</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="错误，404">
<meta http-equiv="description" content="错误信息页">
</head>
<body>
	<%
		String code = (String) request.getParameter("code");
		if (code == null || code == "") {
			code = "400";
		}
		Code errorCode = Code.find(code);
		String error = errorCode.getError();
	%>
	<span>错误代码：<%=code%></span>
	<br>
	<span>错误信息：<%=error%></span>
</body>
</html>
