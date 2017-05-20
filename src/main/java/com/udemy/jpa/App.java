package com.udemy.jpa;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;



public class App {
	
	public static void main(String[] args) {
		

		// helps to instantiate and manage multiple instance
		EntityManagerFactory entityManageFactory = Persistence.createEntityManagerFactory("jpa");
		
		
		//defines persistence related operations on java objects.
		EntityManager entityManager = entityManageFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
	
		//insert
		/**
		Person p1 = new Person("Joe", 18);
		Person p2 = new Person("Joel", 34);
		Person p3 = new Person("Adam", 55);
		Person p4 = new Person("Nicola", 26);
	
		
		
		
		entityManager.persist(p1);
		entityManager.persist(p2);
		entityManager.persist(p3);
		entityManager.persist(p4);
		entityManager.getTransaction().commit();
		**/
		
		//find by id
		/**
		Person p = entityManager.find(Person.class, 1);
 		System.out.println(p.toString());
		 **/
		
		
		
		//delete
		/**
		Person p = entityManager.find(Person.class, 1);
		entityManager.remove(p);
		entityManager.getTransaction().commit();
		**/
		
		
		//JPQL is java persistence query language define to query database 
		
		//Enity Query
		/*
		String sql = "select p from Person p";
		String sql1 = "SELECT p from Person p WHERE p.age <=30";
		String sql2 = "select p from Person p where p.name like '%el'";
		String sql3 = "select p from Person p where p.age between 20 and 30";
		String sql4 = "select p from Person p order by p.age ASC";		
		Query query = entityManager.createQuery(sql);
		*/
		
		//Native Query
		//Query query = entityManager.createNativeQuery("select * from persons where age < 30", Person.class); 
		
		//Another Query from Entity class
		//Query query = entityManager.createNamedQuery("person.getAll"); or
		
		//TypedQuery<Person> query = entityManager.createNamedQuery("person.getAll", Person.class);
		
		TypedQuery<Person> query = entityManager.createNamedQuery("person.getPersonById", Person.class);
		query.setParameter("id", 6);
	
		
		List<Person> people = query.getResultList();
		//List<Person> people = (List<Person>)query.getResultList();
		
		for(Person p : people){
			System.out.println(p.toString());
		} 
		
		
	 
		entityManager.close();
		entityManageFactory.close();
	
		
		
	}

}
