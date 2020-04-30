package com.da.exception;

public enum ErrorCode {
	INTER_SERVER("500","INTERNAL SERVER"),
	FORBIDDEN("403", "Permission denied"),
	RECORD_NOT_FOUND("003", "RECORD_NOT_FOUND"),
	RECORD_NOT_EXISTED("004", "RECORD_NOT_EXISTED"),
	RECORD_EXISTED("041","RECORD_EXISTED");
	
	private String code;
	private String message;
	private ErrorCode(String code, String message) {
		this.code = code;
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	
	
}
