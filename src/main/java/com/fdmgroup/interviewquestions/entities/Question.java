package com.fdmgroup.interviewquestions.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Indexed
@Table(name = "IQ_Question")
@NamedQueries
({
	@NamedQuery(name="Question.getAllQuestions", query="SELECT q FROM Question q")
})
public class Question 
{
	@Id
	//Default strategy is AUTO which generates a unique id
	@GeneratedValue
	private int id;
	@Column(nullable = false)
	
	@Field(index = Index.TOKENIZED, store = Store.NO)
	private String question;
	@Column(nullable = true)
	private String answer;
	//If the question is technical or a soft question
	@Column(name = "question_type", nullable = true)
	private String questionType;
	@Column(nullable = true)
	private String stream;
	@Column(nullable = true)
	private int numberTag;
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getQuestion() 
	{
		return question;
	}
	
	public void setQuestion(String question) 
	{
		this.question = question;
	}
	
	public String getAnswer()
	{
		return answer;
	}
	
	public void setAnswer(String answer) 
	{
		this.answer = answer;
	}
	
	public String getQuestionType() 
	{
		return questionType;
	}
	
	public void setQuestionType(String questionType)
	{
		this.questionType = questionType;
	}
	
	public String getStream() 
	{
		return stream;
	}
	
	public void setStream(String stream) 
	{
		this.stream = stream;
	}
	
	public int getNumberTag() 
	{
		return numberTag;
	}
	
	public void setNumberTag(int numberTag) 
	{
		this.numberTag = numberTag;
	}
}
