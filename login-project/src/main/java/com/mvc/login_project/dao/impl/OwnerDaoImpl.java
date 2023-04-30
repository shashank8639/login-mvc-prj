package com.mvc.login_project.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mvc.login_project.dto.Owner;
import com.mvc.login_project.dto.Worker;


@Repository
public class OwnerDaoImpl {

	EntityManager entityManager=Factory.getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public String saveOwner(Owner owner) {
		entityTransaction.begin();
		entityManager.persist(owner);
		entityTransaction.commit();
		return owner.getEmail()+" is saved";
	}
	
//	
	public String saveWorker(Worker worker) {
		entityTransaction.begin();
		entityManager.persist(worker);
		entityTransaction.commit();
		return worker.getWorkerName()+" is saved";
	}
	
	public Owner getOwnerById(int id) {
		return entityManager.find(Owner.class, id);
	}
	
	public Owner findByEmailAndPassword(String email,String password) {
		
		Query q=entityManager.createQuery("select o from Owner o where email=?1 and password=?2");
		q.setParameter(1,email);
		q.setParameter(2,password);
		
		try {
			Object obj=q.getSingleResult();
			return (Owner) obj;
		}catch(NoResultException n) {
			return null;
		}
		
	}
	
}
