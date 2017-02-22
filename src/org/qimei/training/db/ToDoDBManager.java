package org.qimei.training.db;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.qimei.training.pojo.Task;
import org.qimei.training.pojo.TaskGroup;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.db.SqliteDatabaseType;
import com.j256.ormlite.jdbc.DataSourceConnectionSource;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class ToDoDBManager {
	
	private static ToDoDBManager dbManager;
	private static Dao<Task, Object> taskDao;
	private static Dao<TaskGroup, Object> taskGroupDao;
	private static ConnectionSource connectionSource;

	private ToDoDBManager() {
		super();
	}
	
	public static ToDoDBManager getInstance() throws SQLException {
		if (null == dbManager) {
			dbManager = new ToDoDBManager();
		}

		return dbManager;
	}
	
	public void initDbConnection(String jndiString, boolean isJndi) throws SQLException, NamingException {

		if (isJndi) {
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup(jndiString);
			connectionSource = new DataSourceConnectionSource(dataSource, new SqliteDatabaseType());
		} else {
			connectionSource = new JdbcConnectionSource(jndiString);
		}
		
		initDaoAndTables();
	}
	
	private void initDaoAndTables() throws SQLException {
		dbManager.createDaoObjects();
		dbManager.createTablesIfNotExist();
	}
	
	private void createDaoObjects() throws SQLException {
		taskDao = DaoManager.createDao(connectionSource, Task.class);
		taskGroupDao = DaoManager.createDao(connectionSource, TaskGroup.class);
	}

	private void createTablesIfNotExist() throws SQLException {
		TableUtils.createTableIfNotExists(connectionSource, Task.class);
		TableUtils.createTableIfNotExists(connectionSource, TaskGroup.class);
	}
	
	public Dao<Task, Object> getTaskDao() {
		return taskDao;
	}

	public Dao<TaskGroup, Object> getTaskGroupDao() {
		return taskGroupDao;
	}
}
