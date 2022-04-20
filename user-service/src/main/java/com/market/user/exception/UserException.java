package com.market.user.exception;

@SuppressWarnings("serial")
public class UserException extends Exception {
	public UserException(String message) {
		super(message);
	}

	public UserException(String message, Throwable cause) {
		super(message, cause);
	}
}
