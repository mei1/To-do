package org.qimei.training.svc;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.qimei.training.db.ToDoDBHelper;
import org.qimei.training.pojo.Task;
import org.qimei.training.pojo.TaskGroup;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoSvc {
	
	private static final Logger logger = Logger.getLogger(ToDoSvc.class);

	@RequestMapping(value = "inserttaskdata", method = RequestMethod.POST, produces = "application/json")
	public int insertIntoTask(@RequestBody Task newTask) throws SQLException {
		logger.info("Insert into task request");
		return ToDoDBHelper.getInstance().insertIntoNewTask(newTask);
	}
	
	@RequestMapping(value = "inserttaskgroupdata", method = RequestMethod.POST, produces = "application/json")
	public int insertIntoTaskGroup(@RequestBody TaskGroup taskGroup) throws SQLException{
		logger.info("Insert into task group request");
		return ToDoDBHelper.getInstance().insertIntoTaskGroup(taskGroup);
	}
	
	@RequestMapping(value = "alltasks", method = RequestMethod.GET, produces = "application/json")
	public List<Task> getAllTask() throws SQLException{
		logger.info("Get all task request");
		return ToDoDBHelper.getInstance().getAllTasksFromDB();
	}
	
	@RequestMapping(value = "alltaskgroups", method = RequestMethod.GET, produces = "application/json")
	public List<TaskGroup> getAllTaskGroup() throws SQLException{
		logger.info("Get all task group request");
		return ToDoDBHelper.getInstance().getAllTaskGroupFromDB();
	}

	@RequestMapping(value = "tasksbyid", method = RequestMethod.POST, produces = "application/json")
	public List<Task> getAllTaskById(@RequestBody TaskGroup taskGroupObj) throws SQLException{
		logger.info("Get all task request by id");
		return ToDoDBHelper.getInstance().getAllTasksById(taskGroupObj.getTaskGroupId());
	}
	
	@RequestMapping(value = "taskgroupbyid", method = RequestMethod.POST, produces = "application/json")
	public List<TaskGroup> getAllTaskGroupById(@RequestBody TaskGroup taskGroupObj) throws SQLException{
		logger.info("Get all task group request by id");
		return ToDoDBHelper.getInstance().getAllTaskGroupById(taskGroupObj.getTaskGroupId());
	}
	
	@RequestMapping(value = "deletetask", method = RequestMethod.DELETE, produces = "application/json")
	public int deleteTask(@RequestBody Task taskObj) throws SQLException {
		logger.info("Delete task request");
		return ToDoDBHelper.getInstance().deleteExistingTask(taskObj.getTaskGroup().getTaskGroupId());
	}
	
	@RequestMapping(value = "deletetaskgroup", method = RequestMethod.DELETE, produces = "application/json")
	public int deleteTaskGroup(@RequestBody TaskGroup taskGroupObj) throws SQLException {
		logger.info("Delete task group request");
		return ToDoDBHelper.getInstance().deleteExistingTaskGroup(taskGroupObj.getTaskGroupId());
	}
}
