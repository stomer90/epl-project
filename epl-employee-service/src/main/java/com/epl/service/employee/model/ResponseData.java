package com.epl.service.employee.model;

public class ResponseData<T> {
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

	
	public static <T> ResponseData<T> create(String code, String message, T data) {
		return new ResponseData<T>(code, message, data);
	}

	public ResponseData(String code, String message, T data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
