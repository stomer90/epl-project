package com.epl.service.department.model;

public class ResponseData<T> {
	public static final String SUCCESS = "SUCCESS";
	public static final String ERROR = "ERROR";
	
	private String code;
	private String message;
	private T data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	public ResponseData(String code, String message, T data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public static <T> ResponseData<T> create(String code, String message, T data) {
		return new ResponseData<T>(code, message, data);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
