package com.ssi;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyContextListener
 *
 */
@WebListener
public class MyContextListener implements ServletContextListener {

	Connection con;
    
    public void contextDestroyed(ServletContextEvent arg0)  {
    	try{
    	con.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         try{
        	 Class.forName("com.mysql.jdbc.Driver");
        	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/booksdata","root","root");
        	 ServletContext context=arg0.getServletContext();
        	 context.setAttribute("datacon", con);
        	 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=======>"+con);
         }catch(Exception e){
        	 
        	 e.printStackTrace();	
         }
         
    }
	
}
