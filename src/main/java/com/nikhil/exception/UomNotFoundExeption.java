package com.nikhil.exception;

public class UomNotFoundExeption extends RuntimeException {
	
	public UomNotFoundExeption() {
		super();
	}
	public UomNotFoundExeption(String message) {
		super(message);
	}
}
