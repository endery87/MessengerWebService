package org.ender.webservices.messenger.exception;

public class DataNotFoundException extends RuntimeException{
	
	private static final long serialversionId= 23123123;
	
	public DataNotFoundException(String message)
	{
		super(message);
	}

}
