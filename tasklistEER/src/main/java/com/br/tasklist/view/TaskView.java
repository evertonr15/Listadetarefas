package com.br.tasklist.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import com.br.tasklist.controller.TaskController;
import com.br.tasklist.entity.Task;

@ViewScoped
@ManagedBean
public class TaskView {
	private Task task;
	private TaskController taskController;
	private List<Task> allTasks;
	private Long changeTaskById;

	@PostConstruct
	public void init() {
		task = new Task();
		taskController = new TaskController();
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public TaskController getTaskController() {
		return taskController;
	}

	public void setTaskController(TaskController taskController) {
		this.taskController = taskController;
	}

	public Long getChangeIdTask() {
		return changeTaskById;
	}

	public void setChangeIdTask(Long changeTaskById) {
		this.changeTaskById = changeTaskById;
	}
	
	public void loadTask(ComponentSystemEvent event) {
		if (changeTaskById == null) {
			return;
		}
		task = taskController.getTaskById(changeTaskById);
	}

	public List<Task> getAllTasks() {
		if (allTasks == null) {
			allTasks = taskController.getAllTasks();

		}
		return allTasks;
	}

	public void setAllTasks(List<Task> allTasks) {
		this.allTasks = allTasks;
	}

	public String saveTask() throws Throwable {
		if (task.getNmTask() != null || task.getDsTask() != null) {
			taskController.saveTask(task);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tarefa adicionada", ""));
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Verifique os campos e tente novamente", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

		return "newTask.xhtml";
	}
	
	public String clearFields() {
		return "newTask.xhtml";

	}

	public String deleteTask(String idTask) throws Throwable {
		Long idTaskToDelete = Long.parseLong(idTask);
		taskController.deleteTask(idTaskToDelete);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tarefa excluida", ""));
		
		return "newTask.xhtml";

	}
}
