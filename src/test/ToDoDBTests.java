package test;

import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.qimei.training.db.ToDoDBHelper;
import org.qimei.training.db.ToDoDBManager;
import org.qimei.training.pojo.Task;
import org.qimei.training.pojo.TaskGroup;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ToDoDBTests {

	private static final Logger logger = Logger.getLogger(ToDoDBTests.class);
	
	ToDoDBManager dbManager = null;
	ToDoDBHelper dbHelper = null;
	
	static ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setUp() throws Exception {
		dbManager = ToDoDBManager.getInstance();
		dbManager.initDbConnection("jdbc:sqlite:ToDo.db", false);
		dbHelper = ToDoDBHelper.getInstance();
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertNewTask() throws SQLException {

		TaskGroup newTaskGroup = new TaskGroup();
		newTaskGroup.setTaskGroupId(1);
		
		Task newTask = new Task();
		newTask.setTaskGroup(newTaskGroup);
		newTask.setTaskTitle("Meetup");
		newTask.setTaskContent("Attend meetup @ Chinatown");
		newTask.setTaskDate(new Date());
		
		int rowCount = dbHelper.insertIntoNewTask(newTask);

		assert (rowCount > 0);
	}
	
	@Test
	public void testInsertTaskGroup() throws SQLException {

		TaskGroup taskGroup = new TaskGroup();
		taskGroup.setTaskGroupId(1);
		taskGroup.setGroupName("Personal");
		
		int rowCount = dbHelper.insertIntoTaskGroup(taskGroup);

		assert (rowCount > 0);
	}
}
