package com.fdmgroup.interviewquestions.daos.tests;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.fdmgroup.interviewquestions.daos.JpaCompanyDao;
import com.fdmgroup.interviewquestions.entities.Company;
import com.fdmgroup.interviewquestions.exceptions.IQStorageException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JpaCompanyDaoTest 
{
	private static EntityManagerFactory emf;
	private static JpaCompanyDao jcd;
	private static Company company;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		emf = Persistence.createEntityManagerFactory("IQDatabase");
		jcd = new JpaCompanyDao(emf);
		company = new Company();
		company.setCompanyName("Company A");
		company.setPrimeNumberId(2);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		emf.close();
	}

	@Test
	public void A_testCreate_Success() 
	{
		try 
		{
			jcd.create(company);
		} 
		catch (IQStorageException e) 
		{
			assertTrue(false);
		}
	}
	
	@Test
	public void B_testCreate_Fail() 
	{
		try 
		{
			jcd.create(company);
		} 
		catch (IQStorageException e) 
		{
			assertTrue(true);
			return;
		}
		
		fail();
	}

	@Test
	public void C_testUpdate_Success() 
	{
		company.setCompanyName("Company B");
		try 
		{
			jcd.update(company);
		} 
		catch (IQStorageException e) 
		{
			fail("Failed to update company.");
		}
	}
	
	@Test
	public void D_testUpdate_Fail() 
	{
		Company temp = new Company();
		
		try 
		{
			jcd.update(temp);
		} 
		catch (IQStorageException e) 
		{
			assertTrue(true);
			return;
		}
		
		fail();
	}

	@Test
	public void E_testRead_Success()
	{
		try 
		{
			Company temp = jcd.read("Company B");
			assertEquals(temp.getCompanyName(), company.getCompanyName());
		} 
		catch (IQStorageException e) 
		{
			fail("Failed to read company name.");
		}
	}

	@Test
	public void F_testRead_Fail()
	{
		try 
		{
			Company temp = jcd.read("NULL");
			assertEquals(temp.getCompanyName(), company.getCompanyName());
		} 
		catch (IQStorageException e) 
		{
			assertTrue(true);
			return;
		}
		
		fail();
	}
	
	@Test
	public void G_testReadAll_Success() 
	{
		try 
		{
			List<Company> companies = jcd.readAll();
			assertEquals(companies.size(), 1);
		} 
		catch (IQStorageException e) 
		{
			fail("Failed to read all companies.");
		}
	}

	@Test
	public void H_testReadAll_Fail() 
	{
		//TODO: What would make readAll fail
		//Wrong permission
		fail("Not yet implemented");
	}
	
	@Test
	public void I_testDelete_Success() 
	{
		try 
		{
			jcd.delete(company);
		} 
		catch (IQStorageException e) 
		{
			fail("Failed to delete company.");
		}
	}

	@Test
	public void J_testDelete_Fail() 
	{
		try 
		{
			jcd.delete(company);
		} 
		catch (IQStorageException e) 
		{
			assertTrue(true);
			return;
		}
		
		fail();
	}
}
