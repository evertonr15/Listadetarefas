package com.br.tasklist.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.br.tasklist.Utils.Util;
import com.br.tasklist.entity.Task;

public class TaskDao {

	private EntityManager entityManager = null;

	public TaskDao() {
		this.entityManager = Util.geEntityManager();
	}

	protected EntityManager getEntityManager() {
		if (this.entityManager == null) {
			return Util.geEntityManager();
		}
		return this.entityManager;
	}

	public void saveTask(Task task) {
		getEntityManager().merge(task);
	}

	public void deleteTask(Long idTask) {
		Task task = getEntityManager().getReference(Task.class, idTask);
		getEntityManager().remove(task);
	}

	public Task getTaskByName(String nmTask) {
		Query query = getEntityManager().createQuery("SELECT tsk FROM TASK tsk WHERE tsk.NMTASK = :nmtask");
		query.setParameter("nmtask", nmTask);
		try {
			return (Task) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	public Task getTaskById(Long idTask) {
		return getEntityManager().find(Task.class, idTask);
	}

	public List<Task> getAllTasks() {
		Query query = getEntityManager().createQuery("FROM TASK", Task.class);
		return (List<Task>) query.getResultList();
	}
}
