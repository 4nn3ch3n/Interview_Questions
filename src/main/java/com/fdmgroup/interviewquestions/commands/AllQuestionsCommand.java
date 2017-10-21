package com.fdmgroup.interviewquestions.commands;

import java.util.List;

import com.fdmgroup.interviewquestions.daos.JpaQuestionDao;
import com.fdmgroup.interviewquestions.entities.Question;
import com.fdmgroup.interviewquestions.exceptions.AllQuestionsCommandException;
import com.fdmgroup.interviewquestions.exceptions.CommandException;
import com.fdmgroup.interviewquestions.exceptions.IQStorageException;
import com.fdmgroup.interviewquestions.exceptions.NullEntityManagerFactoryException;
import com.fdmgroup.interviewquestions.factories.JpaDaoFactory;

public class AllQuestionsCommand implements Command<List<Question>>
{	
	@Override
	public List<Question> execute() throws CommandException 
	{
		try 
		{
			JpaQuestionDao jqd = JpaDaoFactory.getQuestionDao();
			List<Question> questions;
			try 
			{
				questions = jqd.readAll();
				return questions;
			} 
			catch (IQStorageException e) 
			{
				throw new AllQuestionsCommandException("Failed to read all questions.");
			}			
		} 
		catch (NullEntityManagerFactoryException e) 
		{
			throw new AllQuestionsCommandException("Entity manager factory is null.");
		}
	}

}
