package com.epl.service.employee.model;

public class EmployeeException extends RuntimeException {

	private String errCode;
	private String errMsg;
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public EmployeeException(String errCode, String errMsg) {
		super();
		this.errCode = errCode;
		this.errMsg = errMsg;
	}
	@Override
	public String toString() {
		return "EmployeeException [errCode=" + errCode + ", errMsg=" + errMsg + "]";
	}
	
}
