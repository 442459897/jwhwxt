package com.muran.api.exception;

public class ServerException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int code;
	private String info;
	private String error;
	private Throwable throwable;

	public ServerException(int code, String info, Throwable throwable) {
		this.code = code;
		this.info = info;
		this.throwable = throwable;
	}

	public ServerException(int code, String info) {
		this.code = code;
		this.info = info;
	}

	public ServerException(GeneralResponseCode responseCode) {
		this.code = responseCode.getCode();
		this.info = responseCode.getError();
	}

	public ServerException(GeneralResponseCode responseCode, String error) {
		this.code = responseCode.getCode();
		this.info = responseCode.getError();
		this.error = error;
	}
	
	public ServerException(Code responseCode, String error) {
		this.code = responseCode.getCode();
		this.info = responseCode.getError();
		this.error = error;
	}
	public ServerException(Code responseCode) {
		this.code = responseCode.getCode();
		this.info = responseCode.getError();
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

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	
}
