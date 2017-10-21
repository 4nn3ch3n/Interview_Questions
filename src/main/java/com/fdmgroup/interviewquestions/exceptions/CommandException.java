package com.fdmgroup.interviewquestions.exceptions;

public class CommandException extends Exception
{
	static final long serialVersionUID = 3050376473468542111L;

	public CommandException()
	{
		super();
	}
	
	public CommandException(String message)
	{
		super(message);
	}
	
	public CommandException(Throwable cause)
	{
		super(cause);
	}
	
	public CommandException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
