package com.fdmgroup.interviewquestions.misc.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.fdmgroup.interviewquestions.exceptions.NoNextPrimeNumberException;
import com.fdmgroup.interviewquestions.misc.PrimeNumber;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PrimeNumberTest 
{
	@Test
	public void A_testInitializePrimeNumbers() 
	{
		PrimeNumber.initializePrimeNumbers();
		try 
		{
			assertEquals(PrimeNumber.getNextPrimeNumberOf(0), 2);
		} 
		catch (NoNextPrimeNumberException e) 
		{
			fail();
		}
	}

	@Test
	public void B_testGetNextPrimeNumberOf_Success()
	{
		try 
		{
			assertEquals(PrimeNumber.getNextPrimeNumberOf(2),3);
		} 
		catch (NoNextPrimeNumberException e)
		{
			fail();
		}
	}
	
	@Test
	public void C_testGetNextPrimeNumberOf_Fail()
	{
		try 
		{
			PrimeNumber.getNextPrimeNumberOf(1000000);
			fail();
		} 
		catch (NoNextPrimeNumberException e) 
		{
			assertTrue(true);
		}
	}

}
