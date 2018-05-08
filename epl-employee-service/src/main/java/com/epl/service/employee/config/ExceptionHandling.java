package com.epl.service.employee.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.epl.service.employee.model.EmployeeException;
import com.epl.service.employee.model.NormalException;
import com.epl.service.employee.model.ResponseData;

@ControllerAdvice
public class ExceptionHandling {

	private static final Logger log = LoggerFactory.getLogger(ExceptionHandling.class);
	
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<ResponseData> catchEmployeeException(EmployeeException ex){
		log.error(">>>>>>>>>>>>>> Employee Exception: " + ex.toString());
		
		ResponseData response = ResponseData.create(ex.getErrCode(), ex.getErrMsg(), null);
		
		return new ResponseEntity<ResponseData>(response, HttpStatus.OK);
	}
	
	@ExceptionHandler(NormalException.class)
	public ResponseEntity<ResponseData> catchNormalException(NormalException ex){
		log.error(">>>>>>>>>>>>>> Normal Exception: " + ex.toString());
		
		ResponseData response = ResponseData.create(ex.getErrCode(), ex.getErrMsg(), null);
		
		return new ResponseEntity<ResponseData>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseData> catchUnknowException(Exception ex){
		log.error(">>>>>>>>>>>>>> Unknown Exception: " + ex.toString());
		
		ResponseData response = ResponseData.create("ERR_UNK", ex.getMessage(), null);
		
		return new ResponseEntity<ResponseData>(response, HttpStatus.BAD_REQUEST);
	}
}
