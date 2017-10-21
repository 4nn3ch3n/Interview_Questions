package com.fdmgroup.interviewquestions.exceptions;

public class AllQuestionsCommandException extends CommandException
{
	private static final long serialVersionUID = 6963038119168965348L;

	public AllQuestionsCommandException() {}
	
	public AllQuestionsCommandException(String message)
	{
		super(message);
	}
	
	public AllQuestionsCommandException(Throwable cause)
	{
		super(cause);
	}
	
	public AllQuestionsCommandException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
