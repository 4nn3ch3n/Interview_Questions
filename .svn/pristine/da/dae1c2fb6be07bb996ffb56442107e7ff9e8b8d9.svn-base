package com.fdmgroup.interviewquestions.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public abstract class JpaDao<T,I> implements Storage<T,I> 
{	
	private EntityManagerFactory emf;
	
	public JpaDao(EntityManagerFactory emf)
	{
		this.emf = emf;
	}

	EntityManager getEntityManager() 
	{
		return emf.createEntityManager();
	}
}
