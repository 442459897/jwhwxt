package com.muran.api.exception;

public class ServerException extends RuntimeException {
	private int code;
	private String info;
	private Throwable throwable;

	public ServerException(int code, String info, Throwable throwable) {
		this.code = code;
		this.info = info;
		this.throwable = throwable;
	}

	public ServerException(int code, String info){
		this.code = code;
		this.info = info;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}
}
