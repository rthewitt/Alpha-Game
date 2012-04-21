package com.alpha.error;

import java.io.IOException;

import com.alpha.game.Resource;

@SuppressWarnings("serial")
public class AlphaResourceException extends IOException {
	
	String errorText;
	
	private static final String resourceInfo = Resource.getInformation();
	
	@SuppressWarnings("unused")
	private AlphaResourceException() {
		// We need a message to be useful here...
	}
	
	public AlphaResourceException(String errorText) {
		super(resourceInfo+errorText);
		this.errorText = errorText;
	}
	
	public AlphaResourceException(Exception e) {
		super(e);
		this.errorText = e.getMessage();
	}
	
	public String getBetterMessage(String m) {
		return Resource.getInformation() + m;
	}
	
	@Override
	public String getMessage() {
		return resourceInfo+"\n"+this.errorText;
	}
	
}