package com.fdmgroup.interviewquestions.factories;

import javax.persistence.EntityManagerFactory;

import com.fdmgroup.interviewquestions.daos.JpaCompanyDao;
import com.fdmgroup.interviewquestions.daos.JpaQuestionDao;
import com.fdmgroup.interviewquestions.exceptions.NullEntityManagerFactoryException;

public class JpaDaoFactory 
{
	private static EntityManagerFactory entityManagerFactory = null;
	
	public static void setEntityManagerFactory(EntityManagerFactory emf)
	{
		entityManagerFactory = emf;
	}
	
	public static JpaCompanyDao getCompanyDao() throws NullEntityManagerFactoryException
	{
		if(entityManagerFactory == null)
		{
			throw new NullEntityManagerFactoryException("Did not initialize entityManagerFactory.");
		}
		
		return new JpaCompanyDao(entityManagerFactory);
	}
	
	public static JpaQuestionDao getQuestionDao() throws NullEntityManagerFactoryException
	{
		if(entityManagerFactory == null)
		{
			throw new NullEntityManagerFactoryException("Did not initialize entityManagerFactory.");
		}
		
		return new JpaQuestionDao(entityManagerFactory);
	}
}
