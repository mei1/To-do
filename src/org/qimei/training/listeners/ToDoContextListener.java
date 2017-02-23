package org.qimei.training.listeners;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.qimei.training.db.ToDoDBManager;

// to start connection with DB with TomCat
public class ToDoContextListener implements ServletContextListener {
	
	private static Logger logger = Logger.getLogger(ToDoContextListener.class);
	private static final String JNDI_EMP_DB = "java:comp/env/jdbc/toDoDb";

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			ToDoDBManager.getInstance().initDbConnection(JNDI_EMP_DB, true);
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (NamingException e) {
			logger.error(e, e);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

}
