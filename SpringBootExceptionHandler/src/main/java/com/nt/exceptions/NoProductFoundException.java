package com.nt.exceptions;

public class NoProductFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoProductFoundException(String msg) {
		super(msg);
	}
}
