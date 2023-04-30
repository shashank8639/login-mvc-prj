package com.mvc.login_project.dao.impl;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mvc.login_project.dto.FoodProduct;

@Repository
public class FoodProductDaoImpl {

	EntityManager entityManager=Factory.getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public String saveProduct(FoodProduct product) {
		entityTransaction.begin();
		entityManager.persist(product);
		entityTransaction.commit();
		return product.getFoodName()+" is saved";
	}
	
	public FoodProduct getProductById(int id) {
		return entityManager.find(FoodProduct.class, id);
	}
	
	public ArrayList<FoodProduct> getAllProducts(){
		Query q=entityManager.createQuery("select p from FoodProduct p");
		
		return (ArrayList<FoodProduct>) q.getResultList();
	}
}
