package test;

import java.sql.SQLException;

import org.junit.Test;
import org.qimei.training.db.ToDoDBManager;

public class ToDoTests {

	@Test
	public void testEmployeeManagementDb() throws SQLException {
		ToDoDBManager toDoDbManager = ToDoDBManager.getInstance();
	}
}
