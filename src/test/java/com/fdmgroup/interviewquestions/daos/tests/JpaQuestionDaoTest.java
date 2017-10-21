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

import com.fdmgroup.interviewquestions.daos.JpaQuestionDao;
import com.fdmgroup.interviewquestions.entities.Question;
import com.fdmgroup.interviewquestions.exceptions.IQStorageException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JpaQuestionDaoTest 
{
	private static EntityManagerFactory emf;
	private static JpaQuestionDao jqd;
	private static Question[] questions;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		emf = Persistence.createEntityManagerFactory("IQDatabase");
		jqd = new JpaQuestionDao(emf);
		questions = new Question[4];
		
		questions[0] = new Question();
		questions[1] = new Question();
		questions[2] = new Question();
		questions[3] = new Question();
		
		questions[0].setQuestion("What is Software Development Life Cycle (SDLC)?");
		questions[1].setQuestion("What is TDD?");
		questions[2].setQuestion("List the 4 pillars of OOP.");
		questions[3].setQuestion("WHat is SDLC?");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		emf.close();
	}

	@Test
	public void A_testCreate_Success() 
	{
		try{		
			for(int i = 0; i < questions.length - 1; i ++)
			{
				jqd.create(questions[i]);
			}
		}
		catch(IQStorageException e)
		{
			fail("Failed to create questions.");
		}
	}

	@Test
	public void B_testCreate_Fail()
	{
		fail("Not yet implemented");
	}
	
	@Test
	public void C_testUpdate_Success() 
	{
		questions[0].setAnswer("It is a process to create and maintain software.");
		try 
		{
			jqd.update(questions[0]);
		} 
		catch (IQStorageException e) 
		{
			fail("Failed to update question.");
		}
	}

	@Test
	public void D_testUpdate_Fail()
	{
		fail("Not yet implemented");
	}
	
	@Test
	public void E_testRead_Id_Success() 
	{
		try 
		{
			Question question = jqd.read(1);
			assertEquals(question.getQuestion(), "What is Software Development Life Cycle (SDLC)?");
		} 
		catch (IQStorageException e) 
		{
			fail("Failed to read question id.");
		}
	}

	@Test
	public void F_testRead_Id_Fail()
	{
		try
		{
			jqd.update(questions[3]);
		} 
		catch (IQStorageException e) 
		{
			assertTrue(true);
			return;
		}
		
		fail("Failed to throw exception.");
	}
	
	@Test
	public void G_testSearch_String_Success()
	{
		try 
		{
			List<Question> questions = jqd.search("what");
			assertEquals(questions.size(), 2);
		} 
		catch (IQStorageException e) 
		{
			fail("Failed to search for questions.");
		}
	}
	
	@Test 
	public void H_testSearch_String_Fail()
	{
		fail("Not yet implemented");
	}
	
	@Test
	public void I_testReadAll_Success() 
	{
		try
		{
			List<Question> questions = jqd.readAll();
			assertEquals(questions.size(), 3);
		}
		catch(IQStorageException e)
		{
			fail("Failed to read all questions.");
		}
	}
	
	@Test
	public void J_testReadAll_Fail()
	{
		//TODO: What would make readAll fail
		//Wrong permission
		fail("Not yet implemented");
	}

	@Test
	public void K_testDelete_Success() 
	{
		try 
		{
			jqd.delete(questions[0]);
		} 
		catch (IQStorageException e) 
		{
			fail("Failed to delete question.");
		}
	}
	
	@Test
	public void L_testDelete_Fail()
	{
		try 
		{
			jqd.delete(questions[3]);
		} 
		catch (IQStorageException e) 
		{
			assertTrue(true);
			return;
		}
		
		fail("Failed to throw exception.");
	}

}
