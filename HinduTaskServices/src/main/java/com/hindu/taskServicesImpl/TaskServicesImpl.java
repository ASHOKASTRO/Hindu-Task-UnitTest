package com.hindu.taskServicesImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.hindu.taskModels.Task;
import com.hindu.taskModels.TaskId;
import com.hindu.taskServices.TaskServices;

@Service(value = "taskServices")
public class TaskServicesImpl implements TaskServices {

	
	@Resource(name = "mongoTemplate")
	private MongoTemplate mongoTemplate;

	@Override
	public void addTask(Task task) {

		String taskId=getTaskId("NEWTASK");
		task.setTaskId(taskId);
		task.setTaskStatus("Pending");
		mongoTemplate.save(task, "Task");
	}

	@Override
	public void deleteTask(String taskId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("taskId").is(taskId));
		mongoTemplate.findAndRemove(query, Task.class,"Task");
		}

	@Override
	public void markTaskStatus(String taskId, String status) {
		Query query = new Query();
		query.addCriteria(Criteria.where("taskId").is(taskId));
 		Update update = new Update();
		update.set("taskStatus", status);
	    mongoTemplate.findAndModify(query, update, Task.class,"Task");
		
	}

	@Override
	public List<Task> retriveTaskByStatus(String status) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("taskStatus").is("Pending"));
		List<Task> task = mongoTemplate.find(query, Task.class,"Task");
		return task;
	}

	@Override
	public List<Task> retriveTaskByPeriority(String periority) {
		Query query = new Query();
		query.addCriteria(Criteria.where("taskPriority").is(periority));
		List<Task> task = mongoTemplate.find(query, Task.class,"Task");
		return task;
	}

	
	@Override
	public List<Task> retriveTask() {
		List<Task> task = mongoTemplate.find(null, Task.class,"Task");
		return task;
	}
	
	@Override
	public String getTaskId(String key) {

		Query query = new Query(Criteria.where("_id").is(key));
		Update update = new Update();
		update.inc("taskId", 1);
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);
		TaskId taskId = mongoTemplate.findAndModify(query, update, options,	TaskId.class);
		if (taskId == null){
			TaskId obj=new TaskId();
			obj.setId("NEWTASK");
			obj.setTaskId(1);
			mongoTemplate.save(obj);
			String nextTaskId = "Hind-" +1;
			return nextTaskId;
		}
		String nextTaskId = "Hind-"+taskId.getTaskId() ;

		return nextTaskId;
	}

	

}
