package com.fdmgroup.interviewquestions.misc;

import com.fdmgroup.interviewquestions.exceptions.NoNextPrimeNumberException;

public class PrimeNumber 
{
	private static int upperPrimeNumberLimit = 100000;
	private static boolean[] primeNumbers;
	
	public static void initializePrimeNumbers()
	{
		primeNumbers = new boolean[upperPrimeNumberLimit];
		//Initialize the primeNumbers array, starting at 2, to true
		for(int index = 2; index < upperPrimeNumberLimit; index ++)
		{
			primeNumbers[index] = true;
		}
		
		for(int i = 2; i < upperPrimeNumberLimit; i ++)
		{
			if(primeNumbers[i])
			{
				for(int x = i + 1; x < upperPrimeNumberLimit; x ++)
				{
					if(x % i == 0)
					{
						primeNumbers[x] = false;
					}
				}
			}
		}
	}
	
	public static int getNextPrimeNumberOf(int primeNumber) throws NoNextPrimeNumberException
	{
		for(int i = primeNumber + 1; i < upperPrimeNumberLimit; i ++)
		{
			if(primeNumbers[i])
			{
				return i;
			}
		}
		
		throw new NoNextPrimeNumberException("Passed the prime numbers limit of " + upperPrimeNumberLimit);
	}
}
