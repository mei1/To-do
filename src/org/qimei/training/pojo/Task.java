package org.qimei.training.pojo;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Tasks")
public class Task {

	@DatabaseField(foreign = true, foreignColumnName = "taskGroupId", canBeNull = false, useGetSet = true)
	private TaskGroup taskGroup;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String taskTitle;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String taskContent;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private Date taskDate;

	public TaskGroup getTaskGroup() {
		return taskGroup;
	}

	public void setTaskGroup(TaskGroup taskGroup) {
		this.taskGroup = taskGroup;
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

	public Date getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(Date taskDate) {
		this.taskDate = taskDate;
	}

}
