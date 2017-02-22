package org.qimei.training.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "TaskGroups")
public class TaskGroup {

	@DatabaseField(generatedId = true, canBeNull = false, useGetSet = true)
	private int taskGroupId;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String groupName;

	public int getTaskGroupId() {
		return taskGroupId;
	}

	public void setTaskGroupId(int taskGroupId) {
		this.taskGroupId = taskGroupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
