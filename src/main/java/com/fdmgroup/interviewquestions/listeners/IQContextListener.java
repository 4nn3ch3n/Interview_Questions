package com.fdmgroup.interviewquestions.listeners;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdmgroup.interviewquestions.factories.JpaDaoFactory;
import com.fdmgroup.interviewquestions.misc.PrimeNumber;

/**
 * Application Lifecycle Listener implementation class IQContextListener
 *
 */
@WebListener
public class IQContextListener implements ServletContextListener 
{
	private EntityManagerFactory emf;

    /**
     * Default constructor. 
     */
    public IQContextListener() 
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  
    { 
         emf.close();
    }
    
    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  
    { 
//    	ApplicationContext appContext = new ClassPathXmlApplicationContext("META-INF/beans.xml");
//    	emf = (EntityManagerFactory) appContext.getBean("entityManagerFactory");
    	
    	emf = Persistence.createEntityManagerFactory("IQDatabase");
    	
    	PrimeNumber.initializePrimeNumbers();        
    	JpaDaoFactory.setEntityManagerFactory(emf);
    	
//    	((ConfigurableApplicationContext)appContext).close();
    }	
}
