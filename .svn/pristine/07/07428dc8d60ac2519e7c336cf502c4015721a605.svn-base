package com.fdmgroup.interviewquestions.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import com.fdmgroup.interviewquestions.entities.Company;
import com.fdmgroup.interviewquestions.exceptions.IQCompanyException;
import com.fdmgroup.interviewquestions.exceptions.IQStorageException;

public class JpaCompanyDao extends JpaDao<Company, Integer>
{

	public JpaCompanyDao(EntityManagerFactory emf) 
	{
		super(emf);
	}

	@Override
	public void create(Company company) throws IQStorageException 
	{
		try
		{
			read(company.getCompanyName());
		}
		catch(IQStorageException iqse)
		{
			System.out.println("new company prime number: " + company.getPrimeNumberId());
			//Add company to the database if the company name does not exist
			EntityManager em = getEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(company);
			et.commit();
			em.close();
			return;
		}
		
		throw new IQStorageException("Company name already exists.");
	}

	@Override
	public void update(Company company) throws IQStorageException 
	{
		read(company.getId());
		
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(company);
		et.commit();
		em.close();		
	}

	@Override
	public Company read(Integer id) throws IQStorageException
	{
		EntityManager em = getEntityManager();
		Company company = (Company) em.find(Company.class, id.intValue());
		em.close();
		
		if(company != null)
		{
			return company;
		}
		
		throw new IQCompanyException("Company does not exist.");
	}
	
	public Company read(String companyName) throws IQStorageException
	{
		try
		{
			EntityManager em = getEntityManager();
			Company company = (Company) em.createNamedQuery("Company.findByCompanyName")
					.setParameter("name", companyName)
					.getSingleResult();
			em.close();
			
			return company;
		}
		catch(NoResultException nre)
		{
			throw new IQCompanyException("Company name does not exist.");
		}
	}

	@Override
	public List<Company> readAll() throws IQStorageException 
	{
		EntityManager em = getEntityManager();
		List<Company> companies = (List<Company>) em.createNamedQuery("Company.getAllCompanies")
				.getResultList();
		em.close();
		return companies;
	}

	@Override
	public void delete(Company company) throws IQStorageException
	{
		Company companyToRemove = read(company.getCompanyName());
		
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(em.contains(company) ? companyToRemove : em.merge(companyToRemove));
		et.commit();
		em.close();
	}
	
	public int getCompanyMaxPrimeId()
	{
		EntityManager em = getEntityManager();
		Integer maxPrime = (Integer) em.createNamedQuery("Company.findMaxPrimeNumber")
				.getSingleResult();
		
		if(maxPrime == null)
			return 0;
		
		return maxPrime.intValue();
			
	}

}
