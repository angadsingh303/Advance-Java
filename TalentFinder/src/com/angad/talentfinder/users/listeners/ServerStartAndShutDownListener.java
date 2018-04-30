package com.angad.talentfinder.users.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServerStartAndShutDownListener
 *
 */
@WebListener
public class ServerStartAndShutDownListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServerStartAndShutDownListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	for(int i=1;i<100;i++){
    		System.out.println("Server going to start.."+i);
    		
    		/*try{
    			//Thread.sleep(200);
    		}
    		catch(Exception e){
    			System.out.println("Exception");
    			
    		}*/
    	}
    	
    }
	
}
