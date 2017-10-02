package com.app.projet.exceptions;

public class OrgUndeletableException extends Exception {
	private String message ="";
	public OrgUndeletableException (String message) {
		this.message=message;
		
	}
	public String getMessage() {
		return message;
	}
	
	

}
