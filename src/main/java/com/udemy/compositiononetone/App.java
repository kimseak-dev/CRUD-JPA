package com.udemy.compositiononetone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	
	public static void main(String[] args) {
		
		EntityManagerFactory enityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		
		EntityManager entityManager = enityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Address address = new Address("Wall Street", 1123);
	
		Employee employee = new Employee();
		employee.setName("Joe Smith");
		
		
		address.setEmployee(employee);
		employee.setAddress(address);
		
		entityManager.persist(employee);
		entityManager.persist(address);
		
		entityManager.getTransaction().commit();
				
		entityManager.close();
		enityManagerFactory.close();
	}

}
