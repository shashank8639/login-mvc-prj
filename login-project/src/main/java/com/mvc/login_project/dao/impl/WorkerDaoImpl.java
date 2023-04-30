package com.mvc.login_project.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mvc.login_project.dto.Worker;

@Repository
public class WorkerDaoImpl {

	EntityManager entityManager=Factory.getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public Worker findByEmailAndPassword(String email,String password) {
		
		Query q=entityManager.createQuery("select w from Worker w where email=?1 and password=?2");
		q.setParameter(1,email);
		q.setParameter(2,password);
		
		try {
			Object obj=q.getSingleResult();
			return (Worker) obj;
		}catch(NoResultException n) {
			return null;
		}
	}
	
}
