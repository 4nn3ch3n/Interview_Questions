package com.fdmgroup.interviewquestions.exceptions;

public class NullEntityManagerFactoryException extends Exception
{
	private static final long serialVersionUID = 579503753707097098L;

	public NullEntityManagerFactoryException()
	{
		super();
	}
	
	public NullEntityManagerFactoryException(String message)
	{
		super(message);
	}
	
	public NullEntityManagerFactoryException(Throwable cause)
	{
		super(cause);
	}
	
	public NullEntityManagerFactoryException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
