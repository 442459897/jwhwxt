package com.muran.api.exception;

import javax.ws.rs.core.Response.Status;

public enum GeneralResponseCode implements ResponseCode {
	OK, BadRequestParams(Status.BAD_REQUEST, 400, "参数错误"), UserTokenException(
			Status.BAD_REQUEST, 400, "未携带UserToken数据或UserToken数据格式错误"), HttpRequestHeaderException(
			Status.BAD_REQUEST, 400, "httprequest headers信息异常，请检查是否服务API规范"), UserSecurityExcepiton(
			Status.UNAUTHORIZED, 401, "用户未登陆或token已过期"), PersmissionForbid(
			Status.FORBIDDEN, 403, "用户无权访问"), RequestInputStreamIOException(
			Status.BAD_REQUEST, 400, "输入流IO异常"), PasswordHashException(
			Status.BAD_REQUEST, 400, "密码加密异常，密码为不小于6位的字母数字组合"), UnKnowError(
			500, "未知异常"), OperationFailed(501, "操作失败"), ActiveMQError(502,
			"消息中间件错误"),

	RoleHasExisted(2055, "角色已存在"), RoleNotFound(2056, "角色信息不存在"), GroupHasExisted(
			2057, "权限组已存在"), GroupNotFound(2058, "权限组信息不存在"), SubMenuExist(
			2059, "存在子菜单"), MenuGroupNotFound(2060, "菜单组信息不存在"), MenuGroupToUserExist(
			2061, "菜单组－用户关系存在"), MenuGroupToMenuExist(2062, "菜单组－菜单关系存在"), 
			RoleNodeNotAllowModify(2063,"节点操作非法");

	GeneralResponseCode() {
	}

	GeneralResponseCode(int code, String error) {
		this.code = code;
		this.error = error;
	}

	GeneralResponseCode(Status status, int code, String error) {
		this.status = status.getStatusCode();
		this.code = code;
		this.error = error;
	}

	private String error;
	private int code = 200;
	private int status = Status.OK.getStatusCode();

	@Override
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String getError() {
		return error;
	}

	@Override
	public int getCode() {
		return code;
	}

}
