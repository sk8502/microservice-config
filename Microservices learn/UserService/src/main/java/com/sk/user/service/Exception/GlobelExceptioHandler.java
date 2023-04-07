package com.sk.user.service.Exception;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sk.user.service.payload.ApiResponce;

@RestControllerAdvice
public class GlobelExceptioHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponce> resourceNotFoundException(ResourceNotFoundException ex){
		String message=ex.getMessage();
		ApiResponce apiResponce=new ApiResponce(message,false);
		return new ResponseEntity<ApiResponce>(apiResponce,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handlemathodargnotvalidexception(MethodArgumentNotValidException ex){
		Map<String, String> resp=new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String filednaame=((FieldError)error).getField();
			String message=error.getDefaultMessage();
			resp.put(filednaame, message);
		});
		
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ApiResponce> handleApiException(ApiException ex){
		String message=ex.getMessage();
		ApiResponce apiResponce=new ApiResponce(message,false);
		return new ResponseEntity<ApiResponce>(apiResponce,HttpStatus.BAD_REQUEST);
	}
}
