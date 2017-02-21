package org.qimei.training.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "TaskGroup")
public class TaskGroup {

	@DatabaseField(foreign = true, foreignColumnName = "taskId", canBeNull = false, useGetSet = true)
	private NewTask newTask;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String groupName;

	public NewTask getNewTask() {
		return newTask;
	}

	public void setNewTask(NewTask newTask) {
		this.newTask = newTask;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
