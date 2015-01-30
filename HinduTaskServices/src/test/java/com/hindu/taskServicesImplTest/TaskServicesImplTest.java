package com.hindu.taskServicesImplTest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hindu.taskModels.Task;
import com.hindu.taskServicesImpl.TaskServicesImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:root-context-test.xml"})
public class TaskServicesImplTest {

	@Resource(name = "mongoTemplate")
	private MongoTemplate mongoTemplate;
	
	@Resource(name="taskServices")
	private TaskServicesImpl taskServices;
	
	@Test
	public void addTask() {
		Task task=new Task();
		String taskId=taskServices.getTaskId("Test Task");
		task.setTaskId(taskId);
		task.setTaskStatus("Completed");
		mongoTemplate.save(task, "Task");
	}
	
	
}
