package com.mvc.login_project.user;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl {

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("login");
	EntityManager entityManager=emf.createEntityManager();
	EntityTransaction et=entityManager.getTransaction();
	
	public String saveUser(UserModel userModel) {
		
		et.begin();
		entityManager.persist(userModel);
		et.commit();
		
		return userModel.getEmail()+" is saved";
	}
	
	public boolean findByEmailAndPassword(String email,String password) {
		
		Query q=entityManager.createQuery("select u from UserModel u where email=?1 and password=?2");
		q.setParameter(1,email);
		q.setParameter(2,password);
		
		try {
			Object o=q.getSingleResult();
			
			if(o!=null) {
				return true;
			}
		}catch (NoResultException n) {   
			
		}
		
		
		return false;
		
	}
	
	public ArrayList<UserModel> getAllUsers(){
		
		Query q=entityManager.createQuery("select u from UserModel u");
		
		return (ArrayList<UserModel>) q.getResultList();
	}
	
	public String delete(String email) {
		
		UserModel user=getUser(email);
		
		if(user!=null) {
			et.begin();
			entityManager.remove(user);
			et.commit();
			
			return email+" is deleted";
		}
		
		return "The data with "+email+" does'nt exist";
	}
	
	public UserModel getUser(String email) {
		
		return entityManager.find(UserModel.class, email);
	}
	
	public String updateUser(UserModel userModel) {
		
		if(userModel!=null) {
			et.begin();
			entityManager.merge(userModel);
			et.commit();
			return userModel.getEmail()+" is updated";
		}
		
		return "updation failed becoz the data with "+userModel.getEmail()+" does'nt exist";
	}
	
	
	
	
	
	
	
	
	
}
