package com.udemy.compositiononetomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	public static void main(String[] args) {
		
		EntityManagerFactory enityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager = enityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		University university = new University("ELETE");
		
		Student s1 = new Student("Joe Smith");
		s1.setUniversity(university);
		
		Student s2 = new Student("Albert Camus");
		s2.setUniversity(university);
		
		entityManager.persist(university);
		entityManager.persist(s1);
		entityManager.persist(s2);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		enityManagerFactory.close();
		
	}

}
