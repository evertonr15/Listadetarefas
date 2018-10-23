package com.br.tasklist.faces.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.br.tasklist.controller.TaskController;
import com.br.tasklist.entity.Task;

@FacesConverter(forClass = Task.class)
public class TaskConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		TaskController taskController = new TaskController();
		return taskController.getTaskById(Long.parseLong(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Task task = (Task) value;
		return String.valueOf(task.getIdTask());
	}

}
