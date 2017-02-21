package org.qimei.training.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "NewTask")
public class NewTask {

	@DatabaseField(generatedId = true, canBeNull = false, useGetSet = true)
	private int taskId;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String taskTitle;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String taskContent;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getTaskContent() {
		return taskContent;
	}

	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}

}
