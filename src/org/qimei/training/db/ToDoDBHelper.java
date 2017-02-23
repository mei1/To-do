package org.qimei.training.db;

import java.sql.SQLException;
import java.util.List;

import org.qimei.training.pojo.Task;
import org.qimei.training.pojo.TaskGroup;

import com.j256.ormlite.stmt.DeleteBuilder;

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
	
	public int insertIntoNewTask(Task newTask) throws SQLException{
		int rowCount = ToDoDBManager.getInstance().getTaskDao().create(newTask);
		
		return rowCount;
	}
	
	public int insertIntoTaskGroup(TaskGroup taskGroup) throws SQLException{
		int rowCount = ToDoDBManager.getInstance().getTaskGroupDao().create(taskGroup);
		
		return rowCount;
	}
	
	public List<Task> getAllTasksFromDB() throws SQLException{
		return ToDoDBManager.getInstance().getTaskDao().queryForAll();
	}
	
	public List<TaskGroup> getAllTaskGroupFromDB() throws SQLException{
		return ToDoDBManager.getInstance().getTaskGroupDao().queryForAll();
	}
	
	public List<Task> getAllTasksById(int taskGroupId) throws SQLException{
		return ToDoDBManager.getInstance().getTaskDao().queryForEq("TaskGroup_taskGroupId", taskGroupId);
	}
	
	public List<TaskGroup> getAllTaskGroupById(int taskGroupId) throws SQLException{
		return ToDoDBManager.getInstance().getTaskGroupDao().queryForEq("taskGroupId", taskGroupId);
	}

	public int deleteExistingTask(int taskGroupId) throws SQLException{
		DeleteBuilder<Task, Object> deleteBuilder = ToDoDBManager.getInstance().getTaskDao().deleteBuilder();
		
		return deleteBuilder.delete();	
	}
	
	public int deleteExistingTaskGroup(int taskGroupId) throws SQLException{
		DeleteBuilder<TaskGroup, Object> deleteBuilder = ToDoDBManager.getInstance().getTaskGroupDao().deleteBuilder();
		
		return deleteBuilder.delete();
	}
}
