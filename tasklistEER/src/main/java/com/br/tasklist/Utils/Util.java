package com.br.tasklist.Utils;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public class Util {
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY;

	public static void getEntityManagetFactory() {
		if (ENTITY_MANAGER_FACTORY == null) {
			ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("tasklistDBEER");
		}
	}

	public static EntityManager geEntityManager() {
		FacesContext fContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) fContext.getExternalContext().getRequest();

		return (EntityManager) request.getAttribute("ENTITY_MANAGER");
	}

	public static EntityManager getEntityManagerRequest(ServletRequest requestParam) {
		HttpServletRequest request = (HttpServletRequest) requestParam;

		EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

		request.setAttribute("ENTITY_MANAGER", entityManager);

		return entityManager;
	}

	public static void closeEntityManagetFactory() {
		ENTITY_MANAGER_FACTORY.close();
	}
}
