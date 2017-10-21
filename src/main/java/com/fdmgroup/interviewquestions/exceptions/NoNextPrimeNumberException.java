package com.fdmgroup.interviewquestions.exceptions;

public class NoNextPrimeNumberException extends Exception
{	
	private static final long serialVersionUID = 7819302208697786663L;

	public NoNextPrimeNumberException()
	{
		super();
	}
	
	public NoNextPrimeNumberException(String message)
	{
		super(message);
	}
	
	public NoNextPrimeNumberException(Throwable cause)
	{
		super(cause);
	}
	
	public NoNextPrimeNumberException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
