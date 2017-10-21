package com.fdmgroup.interviewquestions.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdmgroup.interviewquestions.commands.AddCompanyCommand;
import com.fdmgroup.interviewquestions.commands.AddQuestionCommand;
import com.fdmgroup.interviewquestions.exceptions.CommandException;

@Controller
public class IQModifyDatabaseController 
{
	@RequestMapping("/addCompany")
	public String addCompany(HttpServletRequest request) throws CommandException
	{
		AddCompanyCommand acc = new AddCompanyCommand(request.getParameter("companyName"));
		acc.execute();
		return "redirect:/";
	}
	
	@RequestMapping("/addQuestion")
	public String addQuestion(HttpServletRequest request) throws CommandException
	{
		String questionText = request.getParameter("questionText");
		String answerText = request.getParameter("answerText");
		
		AddQuestionCommand aqc = new AddQuestionCommand(questionText, answerText);
		aqc.execute();
		return "redirect:/";
	}
	
	@ExceptionHandler(Exception.class)
	public String error()
	{
		return "Error";
	}
}
