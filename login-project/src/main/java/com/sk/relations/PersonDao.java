package com.sk.relations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersonDao {

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("login");
	EntityManager entityManager=emf.createEntityManager();
	EntityTransaction et=entityManager.getTransaction();
	
	public void save(Person person,Address address) {
		
		et.begin();
		entityManager.persist(person);
		entityManager.persist(address);
		et.commit();
		
		System.out.println("saved");
	}
	
	
	
	
	
	
	
	
	
}
