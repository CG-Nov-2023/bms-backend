package com.bms.exception;

public class NoBooksAvailableException extends RuntimeException {

	@Override
	public String getMessage() {
		return "No Books Available!";
	}
}
