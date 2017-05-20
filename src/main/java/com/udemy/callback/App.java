package com.udemy.callback;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager = entityMangerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Article article = new Article("Albert Enstien Relativity");
		
		entityManager.persist(article);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityMangerFactory.close();
		
		
	}
}
