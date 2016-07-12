package com.muran.api.exception;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.muran.model.Activity;

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public enum Code implements ResponseCode {
	OK, BadRequestParams(Status.BAD_REQUEST, 400, "参数错误"), UserTokenException(
			Status.BAD_REQUEST, 400, "未携带UserToken数据或UserToken数据格式错误"), HttpRequestHeaderException(
			Status.BAD_REQUEST, 400, "httprequest headers信息异常，请检查是否服务API规范"), UserSecurityExcepiton(
			Status.UNAUTHORIZED, 401, "用户未登陆或token已过期"), PersmissionForbid(
			Status.FORBIDDEN, 403, "用户无权访问"), RequestInputStreamIOException(
			Status.BAD_REQUEST, 400, "输入流IO异常"), PasswordHashException(
			Status.BAD_REQUEST, 400, "密码加密异常，密码为不小于6位的字母数字组合"), UnKnowError(
			500, "未知异常"), OperationFailed(501, "操作失败"), ActiveMQError(502,
			"消息中间件错误"),
	// 业务异常：
	// 系统配置错误：7**
	AboutUsCategoryNameExsited(710, "分类名称已存在"), ProvinceNameOrCodeExisted(711,
			"省市名称或编码不存在"), UserNoExisted(712, "未查询到用户信息"), ProfessionalNameExisted(
			713, "职业名称已存在"), UsernameHasExsited(714, "用户名重复"), IndustryNotFound(
			715, "未找到行业信息"), AdClassifyNotFound(716, "未找到广告分类"), AdClassifyHasExsited(
			717, "广告分类已 存在"), ExceptInfoNotFound(718, " 未找到敬请期待信息"), ClientKeyHasExist(
			719, "客户端key已存在"), ClientKeyNotFound(720, "关系不存在"),

	RoleHasExisted(2055, "角色已存在"), RoleNotFound(2056, "角色信息不存在"), GroupHasExisted(
			2057, "权限组已存在"), GroupNotFound(2058, "权限组信息不存在"), SubMenuExist(
			2059, "存在子菜单"), MenuGroupNotFound(2060, "菜单组信息不存在"), MenuGroupToUserExist(
			2061, "菜单组－用户关系存在"), MenuGroupToMenuExist(2062, "菜单组－菜单关系存在"), RoleNodeNotAllowModify(
			2063, "节点操作非法"), RoleHasInit(2064, "权限已经初始化"), RoleInitError(2064,
			"权限初始化失败"),

	UsernameFormatException(1002, "用户名格式异常"), VerifyCodeInvalidException(1004,
			"验证码错误或者已过期"), MoblieHasRegister(1005, "手机号已注册"), UserOrPasswordErrorException(
			1006, "密码或账户错误"), PasswordUnCorrect(1007, "密码错误"), PasswordLengthException(
			1008, "密码少于6位异常"), UserNotFound(1009, "用户不存在"), FrequentSendCode(
			1010, "频繁发送"),
	
	ActivityNoExisted(1050,"活动不存在"),
	SignUpTopOver(1051,"报名已满"),
	DataExisted(1052,"数据已存在"),
	// 微信错误：7**
	CreateMenuFail(9001, "创建微信菜单失败！");
	Code() {
	}

	Code(int code, String error) {
		this.code = code;
		this.error = error;
	}

	Code(Status status, int code, String error) {
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

	private static final Map<String, Code> lookup = new HashMap<String, Code>();

	static {
		for (Code e : EnumSet.allOf(Code.class)) {
			lookup.put(String.valueOf(e.code), e);
		}
	}

	public static Code find(String code) {
		Code value = lookup.get(code);
		if (value == null) {
			return Code.BadRequestParams;
		}
		return value;
	}

}
