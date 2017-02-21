package org.qimei.training.db;

import java.sql.SQLException;

import org.qimei.training.pojo.NewTask;
import org.qimei.training.pojo.TaskGroup;

public class ToDoDBHelper {
	
	private static ToDoDBHelper toDoTaskDBHelper = null;
	
	private ToDoDBHelper() {
		super();
	}
	
	public static ToDoDBHelper getInstance() {
		if (toDoTaskDBHelper == null) {
			toDoTaskDBHelper = new ToDoDBHelper();
		}
		return toDoTaskDBHelper;
	}
	
	public int insertIntoNewTask(NewTask newTask) throws SQLException{
		int rowCount = ToDoDBManager.getInstance().getNewTaskDao().create(newTask);
		
		return rowCount;
	}
	
	public int insertIntoTaskGroup(TaskGroup taskGroup) throws SQLException{
		int rowCount = ToDoDBManager.getInstance().getTaskGroupDao().create(taskGroup);
		
		return rowCount;
	}

}
