package com.fdmgroup.interviewquestions.exceptions;

public class AllCompaniesCommandException extends CommandException
{
	private static final long serialVersionUID = 8891797294606389827L;
	
	public AllCompaniesCommandException() {}
	
	public AllCompaniesCommandException(String message)
	{
		super(message);
	}
	
	public AllCompaniesCommandException(Throwable cause)
	{
		super(cause);
	}
	
	public AllCompaniesCommandException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
