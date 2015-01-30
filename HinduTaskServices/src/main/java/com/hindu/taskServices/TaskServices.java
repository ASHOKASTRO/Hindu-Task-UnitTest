package com.hindu.taskServices;

import java.util.List;

import com.hindu.taskModels.Task;

public interface TaskServices {

	public void addTask(Task task);

	public void deleteTask(String taskId);
	
	public List<Task> retriveTask();

	public void markTaskStatus(String taskId,String status);
	
	public List<Task> retriveTaskByStatus(String status);
	
	public List<Task> retriveTaskByPeriority(String periority);

	public String getTaskId(String key);
}
