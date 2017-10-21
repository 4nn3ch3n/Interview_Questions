package com.fdmgroup.interviewquestions.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "IQ_Company")
@NamedQueries
({
	@NamedQuery(name="Company.getAllCompanies", query="SELECT c FROM Company c"),
	@NamedQuery(name="Company.findByCompanyName", query="SELECT c FROM Company c WHERE c.companyName = :name"),
	@NamedQuery(name="Company.findMaxPrimeNumber", query = "SELECT MAX(c.primeNumberId) FROM Company c")
})
public class Company 
{
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "company_name", unique = true, nullable = false)
	private String companyName;
	@Column(name = "prime_number_id", unique = true, nullable = false)
	private int primeNumberId;
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getCompanyName()
	{
		return companyName;
	}
	
	public void setCompanyName(String companyName) 
	{
		this.companyName = companyName;
	}
	
	public int getPrimeNumberId()
	{
		return primeNumberId;
	}
	
	public void setPrimeNumberId(int primeNumberId) 
	{
		this.primeNumberId = primeNumberId;
	}
}
