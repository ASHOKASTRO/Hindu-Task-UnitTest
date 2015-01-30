package com.hindu.taskModels;

import org.springframework.data.annotation.Id;

public class Task {

	@Id
	private String taskId;
	private String taskName;
	private String taskPriority;
	private String taskStatus;
	private String taskDescription;
	
	
	/**
	 * @return the taskId
	 */
	public String getTaskId() {
		return taskId;
	}
	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}
	/**
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	/**
	 * @return the taskPriority
	 */
	public String getTaskPriority() {
		return taskPriority;
	}
	/**
	 * @param taskPriority the taskPriority to set
	 */
	public void setTaskPriority(String taskPriority) {
		this.taskPriority = taskPriority;
	}
	/**
	 * @return the taskStatus
	 */
	public String getTaskStatus() {
		return taskStatus;
	}
	/**
	 * @param taskStatus the taskStatus to set
	 */
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	/**
	 * @return the taskDescription
	 */
	public String getTaskDescription() {
		return taskDescription;
	}
	/**
	 * @param taskDescription the taskDescription to set
	 */
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	
	
}
