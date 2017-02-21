package test;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.qimei.training.db.ToDoDBHelper;
import org.qimei.training.db.ToDoDBManager;
import org.qimei.training.pojo.NewTask;
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

		NewTask newTask = new NewTask();
		newTask.setTaskId(1);
		newTask.setTaskTitle("Meetup");
		newTask.setTaskContent("Attend meetup @ Chinatown");
		
		int rowCount = dbHelper.insertIntoNewTask(newTask);

		assert (rowCount > 0);
	}
	
	@Test
	public void testInsertTaskGroup() throws SQLException {

		TaskGroup taskGroup = new TaskGroup();
		NewTask newTask = new NewTask();
		taskGroup.setGroupName("Personal");
		taskGroup.setNewTask(newTask);
		
		int rowCount = dbHelper.insertIntoTaskGroup(taskGroup);

		assert (rowCount > 0);
	}
}
