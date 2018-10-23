package com.br.tasklist.controller;

import java.util.List;

import com.br.tasklist.dao.TaskDao;
import com.br.tasklist.entity.Task;

public class TaskController {
	private TaskDao taskDao;

	public TaskController() {
		taskDao = new TaskDao();
	}

	public void saveTask(Task task) {
		taskDao.saveTask(task);
	}

	public void deleteTask(Long id) {
		taskDao.deleteTask(id);

	}

	public Task getTaskByName(String nmTask) {
		return taskDao.getTaskByName(nmTask);
	}

	public Task getTaskById(Long idTask) {
		return taskDao.getTaskById(idTask);
	}

	public List<Task> getAllTasks() {
		return taskDao.getAllTasks();
	}
}
