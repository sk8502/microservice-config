package com.sk.hotel.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
	
	String resourceName;
	String fieldName;
	long fieldvalue;
	
  public ResourceNotFoundException(String resourceName) {
		super(String.format("%s Not found with %s : %s ", resourceName));
		this.resourceName = resourceName;
		
	}
}
