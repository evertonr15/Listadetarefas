package com.br.tasklist.filter;

import javax.servlet.annotation.WebFilter;

import com.br.tasklist.Utils.Util;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@WebFilter(servletNames = "Filter Servlet")
public class TaskFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter) throws IOException, ServletException {
		EntityManager entityManager = Util.getEntityManagerRequest(request);
		entityManager.getTransaction().begin();
		filter.doFilter(request, response);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public void init(FilterConfig filterConf) throws ServletException {
		Util.getEntityManagetFactory();
	}

	@Override
	public void destroy() {
		Util.closeEntityManagetFactory();
	}
}
