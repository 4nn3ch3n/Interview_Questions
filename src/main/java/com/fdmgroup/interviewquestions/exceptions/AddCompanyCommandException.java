package com.fdmgroup.interviewquestions.exceptions;

public class AddCompanyCommandException extends CommandException
{
	private static final long serialVersionUID = -7708367178555327487L;

	public AddCompanyCommandException() {}
	
	public AddCompanyCommandException(String message)
	{
		super(message);
	}
	
	public AddCompanyCommandException(Throwable cause)
	{
		super(cause);
	}
	
	public AddCompanyCommandException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
