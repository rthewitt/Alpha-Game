package com.alpha.error;

public class AlphaException extends Exception {
	String errorText;
	
	private AlphaException() {
		// no.
	}
	
	public AlphaException(String errorText) {
		super(errorText);
		this.errorText = errorText;
	}
	
	public AlphaException(Exception e) {
		super(e);
		this.errorText = e.getMessage();
	}
	
}