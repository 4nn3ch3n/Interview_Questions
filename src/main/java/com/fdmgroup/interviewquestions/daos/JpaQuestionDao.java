package com.fdmgroup.interviewquestions.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.hibernate.search.SearchFactory;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.EntityContext;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.search.query.dsl.QueryContextBuilder;

import com.fdmgroup.interviewquestions.entities.Question;
import com.fdmgroup.interviewquestions.exceptions.IQQuestionException;
import com.fdmgroup.interviewquestions.exceptions.IQStorageException;

public class JpaQuestionDao extends JpaDao<Question, Integer>
{

	public JpaQuestionDao(EntityManagerFactory emf) 
	{
		super(emf);
	}

	@Override
	public void create(Question question) throws IQStorageException 
	{
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(question);
		et.commit();
		em.close();
	}

	@Override
	public void update(Question question) throws IQStorageException
	{
		read(question.getId());
		
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(question);
		et.commit();
		em.close();
	}

	@Override
	public Question read(Integer id) throws IQStorageException 
	{
		EntityManager em = getEntityManager();
		Question question = em.find(Question.class, id.intValue());
		
		if(question != null)
			return question;
		
		throw new IQQuestionException("Question id does not exist.");
	}
	
	public List<Question> search(String textToSearch) throws IQStorageException
	{
		EntityManager em = getEntityManager();
		FullTextEntityManager ftem = Search.getFullTextEntityManager(em);
		EntityTransaction et = em.getTransaction();
		et.begin();
		
//		QueryBuilder qb = ftem.getSearchFactory().buildQueryBuilder()
//				.forEntity(Question.class).get();
		SearchFactory sf = ftem.getSearchFactory();
		QueryContextBuilder qcb = sf.buildQueryBuilder();
		EntityContext ec = qcb.forEntity(Question.class);
		QueryBuilder qb = ec.get();
		
		org.apache.lucene.search.Query luceneQuery = qb.keyword()
				.onFields("question").matching(textToSearch).createQuery();
		
		javax.persistence.Query jpaQuery = ftem.createFullTextQuery(luceneQuery, Question.class);
		
		List<Question> questions = (List<Question>) jpaQuery.getResultList();
		
		et.commit();
		em.close();
		
		return questions;
	}

	@Override
	public List<Question> readAll() throws IQStorageException
	{
		EntityManager em = getEntityManager();
		List<Question> questions = (List<Question>) em.createNamedQuery("Question.getAllQuestions")
				.getResultList();
		em.close();
		return questions;
	}

	@Override
	public void delete(Question question) throws IQStorageException 
	{
		Question questionToRemove = read(question.getId());
		
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(em.contains(question) ? questionToRemove : em.merge(questionToRemove));
		et.commit();
		em.close();
	}
	
}
