package com.bms.exception;

public class JwtException extends RuntimeException{
	String msg;

	public JwtException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}

	
}
