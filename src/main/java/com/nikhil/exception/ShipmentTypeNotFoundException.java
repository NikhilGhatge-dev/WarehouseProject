package com.nikhil.exception;

public class ShipmentTypeNotFoundException extends RuntimeException {
	
	private static final long serialVerionUID=1L;
	public ShipmentTypeNotFoundException() {
		super();
	}
	
	public ShipmentTypeNotFoundException(String message) {
		super(message);
	}
	
	
}
