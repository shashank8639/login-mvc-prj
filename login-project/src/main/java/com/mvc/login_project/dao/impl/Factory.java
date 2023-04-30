package com.mvc.login_project.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Factory {

	public static EntityManager getEntityManager() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hotel");
		return emf.createEntityManager();
	}
}
