package com.fdmgroup.interviewquestions.commands;

import java.util.List;

import com.fdmgroup.interviewquestions.daos.JpaCompanyDao;
import com.fdmgroup.interviewquestions.entities.Company;
import com.fdmgroup.interviewquestions.exceptions.AllCompaniesCommandException;
import com.fdmgroup.interviewquestions.exceptions.CommandException;
import com.fdmgroup.interviewquestions.exceptions.IQStorageException;
import com.fdmgroup.interviewquestions.exceptions.NullEntityManagerFactoryException;
import com.fdmgroup.interviewquestions.factories.JpaDaoFactory;

public class AllCompaniesCommand implements Command<List<Company>>
{
	@Override
	public List<Company> execute() throws CommandException 
	{
		try 
		{
			JpaCompanyDao jcd = JpaDaoFactory.getCompanyDao();
			try 
			{
				List<Company> companies = jcd.readAll();
				return companies;
			} 
			catch (IQStorageException e) 
			{
				throw new AllCompaniesCommandException("Error retrieving all companies.");
			}
		} 
		catch (NullEntityManagerFactoryException e) 
		{
			throw new AllCompaniesCommandException("Entity manager factory is null.");
		}		
	}	
}
