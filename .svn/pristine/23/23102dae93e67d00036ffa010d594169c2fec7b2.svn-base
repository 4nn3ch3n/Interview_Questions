package com.fdmgroup.interviewquestions.commands;

import com.fdmgroup.interviewquestions.daos.JpaQuestionDao;
import com.fdmgroup.interviewquestions.entities.Question;
import com.fdmgroup.interviewquestions.exceptions.AddQuestionCommandException;
import com.fdmgroup.interviewquestions.exceptions.CommandException;
import com.fdmgroup.interviewquestions.exceptions.IQStorageException;
import com.fdmgroup.interviewquestions.exceptions.NullEntityManagerFactoryException;
import com.fdmgroup.interviewquestions.factories.JpaDaoFactory;

public class AddQuestionCommand implements Command<Question>
{
	private Question question;
	
	public AddQuestionCommand(String questionText, String answerText)
	{
		question = new Question();
		question.setQuestion(questionText);
		question.setAnswer(answerText);
	}
	
	@Override
	public Question execute() throws CommandException 
	{	
			JpaQuestionDao jqd;
			try {
				jqd = JpaDaoFactory.getQuestionDao();
				jqd.create(question);
			} 
			catch (NullEntityManagerFactoryException e) 
			{
				throw new AddQuestionCommandException("Entity manager factory was not initialized.");
			} 
			catch (IQStorageException e) 
			{
				//TODO: Have a more detailed error message
				throw new AddQuestionCommandException("Failed to create question.");
			}					
		
		return question;
	}

}
