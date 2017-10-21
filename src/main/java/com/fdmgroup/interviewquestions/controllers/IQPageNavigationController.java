package com.fdmgroup.interviewquestions.controllers;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdmgroup.interviewquestions.commands.AllCompaniesCommand;
import com.fdmgroup.interviewquestions.commands.AllQuestionsCommand;
import com.fdmgroup.interviewquestions.entities.Company;
import com.fdmgroup.interviewquestions.entities.Question;
import com.fdmgroup.interviewquestions.exceptions.CommandException;

@Controller
public class IQPageNavigationController 
{
	@RequestMapping("/")
	public String viewIndex(HttpServletRequest request) throws CommandException
	{
		ServletContext sc = request.getSession().getServletContext();
		List<Company> companies = new AllCompaniesCommand().execute();
		sc.setAttribute("companies", companies);
		
		List<Question> questions = new AllQuestionsCommand().execute();
		sc.setAttribute("questions", questions);
		return "index";
	}
	
	@RequestMapping("/AddQuestionPage")
	public String viewAddQuestionPage()
	{
		return "AddQuestion";
	}
	
	@RequestMapping("/AddCompanyPage")
	public String viewAddCompanyPage()
	{
		return "AddCompany";
	}
	
	@RequestMapping("/QuestionResultsPage")
	public String viewQuestionResults()
	{
		return "QuestionResults";
	}
}
