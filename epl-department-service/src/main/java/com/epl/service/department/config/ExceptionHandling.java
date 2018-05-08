package com.epl.service.department.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.epl.service.department.model.EmployeeServiceException;
import com.epl.service.department.model.ResponseData;

@ControllerAdvice
public class ExceptionHandling {
private static final Logger log = LoggerFactory.getLogger(ExceptionHandling.class);
	
	@ExceptionHandler(EmployeeServiceException.class)
	public ResponseEntity<ResponseData<Object>> catchEmployeeException(EmployeeServiceException ex){
		log.error(">>>>>>>>>>>>>> EmployeeService Exception: " + ex.toString());
		
		ResponseData<Object> response = ResponseData.create(ex.getErrCode(), ex.getErrMsg(), null);
		
		return new ResponseEntity<ResponseData<Object>>(response, HttpStatus.OK);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseData<Object>> catchUnknowException(Exception ex){
		log.error(">>>>>>>>>>>>>> Unknown Exception: " + ex.toString());
		
		ResponseData<Object> response = ResponseData.create("ERR_UNK", ex.getMessage(), null);
		
		return new ResponseEntity<ResponseData<Object>>(response, HttpStatus.BAD_REQUEST);
	}
}
