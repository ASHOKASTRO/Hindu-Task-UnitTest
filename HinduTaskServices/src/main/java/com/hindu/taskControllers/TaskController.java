package com.hindu.taskControllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hindu.taskModels.Response;
import com.hindu.taskModels.Task;
import com.hindu.taskServicesImpl.TaskServicesImpl;

@Controller
@RequestMapping(value="hindu")
public class TaskController {

@Resource (name="taskServices")
private TaskServicesImpl taskServices;
	@RequestMapping(value = "/addTask", method = RequestMethod.GET)

	public 	@ResponseBody Response addTask(@RequestParam("taskName") String taskName,@RequestParam("taskPriority") String taskPriority,@RequestParam("taskDescription") String taskDescription)
	{
		Task task=new Task();
		task.setTaskName(taskName);
		task.setTaskPriority(taskPriority);
		task.setTaskDescription(taskDescription);
		taskServices.addTask(task);
		Response response=new Response();
		response.setStatusCode(HttpStatus.OK.value());
		response.setStatusMessage("successfull");
		return response;
	}

	@RequestMapping(value = "/deleteTask", method = RequestMethod.GET)
	@ResponseBody
	public Response deleteTask(@RequestParam("taskId") String taskId)
	{
		taskServices.deleteTask(taskId);
		Response response=new Response();
		response.setStatusCode(HttpStatus.OK.value());
		response.setStatusMessage("successfull");
		return response;
	}
	
	@RequestMapping(value = "/changeStatus", method = RequestMethod.GET)
	@ResponseBody
	public Response markTaskStatus(@RequestParam("taskId") String taskId,@RequestParam("taskStatus") String taskStatus)
	{
		taskServices.markTaskStatus(taskId, taskStatus);;
		Response response=new Response();
		response.setStatusCode(HttpStatus.OK.value());
		response.setStatusMessage("successfull");
		return response;
	}
	
	@RequestMapping(value = "/retriveTaskByStatus", method = RequestMethod.GET)
	@ResponseBody
	public List<Task> retriveTaskByStatus(@RequestParam("taskStatus") String taskStatus)
	{
		List<Task> task=taskServices.retriveTaskByStatus(taskStatus);
		return task;
	}
	
	@RequestMapping(value = "/retriveTaskByPeriority", method = RequestMethod.GET)
	@ResponseBody
	public List<Task> retriveTaskByPeriority(@RequestParam("taskPriority") String taskPriority)
	{
		List<Task> task=taskServices.retriveTaskByPeriority(taskPriority);
		return task;
	}
	
	@RequestMapping(value = "/retriveTask", method = RequestMethod.GET)
	@ResponseBody
	public List<Task> retriveTask()
	{
		List<Task> task=taskServices.retriveTask();
		return task;
	}
}
