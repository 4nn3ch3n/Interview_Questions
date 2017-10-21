package com.fdmgroup.interviewquestions.commands;

import com.fdmgroup.interviewquestions.daos.JpaCompanyDao;
import com.fdmgroup.interviewquestions.entities.Company;
import com.fdmgroup.interviewquestions.exceptions.AddCompanyCommandException;
import com.fdmgroup.interviewquestions.exceptions.CommandException;
import com.fdmgroup.interviewquestions.exceptions.IQStorageException;
import com.fdmgroup.interviewquestions.exceptions.NoNextPrimeNumberException;
import com.fdmgroup.interviewquestions.exceptions.NullEntityManagerFactoryException;
import com.fdmgroup.interviewquestions.factories.JpaDaoFactory;
import com.fdmgroup.interviewquestions.misc.PrimeNumber;

public class AddCompanyCommand implements Command<Company>
{
	private String companyName;
	
	public AddCompanyCommand(String c)
	{
		companyName = c;
	}
	
	@Override
	public Company execute() throws CommandException
	{
		Company company = new Company();
		company.setCompanyName(companyName);
		
		try 
		{
			JpaCompanyDao jcd = JpaDaoFactory.getCompanyDao();
			int maxPrimeNumber = jcd.getCompanyMaxPrimeId();
			System.out.println("Max prime in database: " + maxPrimeNumber);
			try 
			{
				company.setPrimeNumberId(PrimeNumber.getNextPrimeNumberOf(maxPrimeNumber));
			} 
			catch (NoNextPrimeNumberException e1) 
			{
				throw new AddCompanyCommandException("Number of companies exceed known prime numbers.");
			}
			
			try 
			{
				jcd.create(company);
			} 
			catch (IQStorageException e) 
			{
				throw new AddCompanyCommandException("Company name already exists.");
			}			
		} 
		catch (NullEntityManagerFactoryException e) 
		{
			throw new AddCompanyCommandException("Entity manager factory is null.");
		}
		
		return company;
	}

}
