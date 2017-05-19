package com.udemy.mapped;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("psersonal_jpa");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Citizen c = new Citizen();
		c.setName("Joe Smith");
		c.setAge(29);
		c.setDrivingLicence("Joe driving licence");
		
		entityManager.persist(c);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		
	}

}
