package com.udemy.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name ="persons")
//@NamedQuery(name="person.getAll", query="SELECT p FROM Person p")
@NamedQueries(
				{
					@NamedQuery(name="person.getAll", query="SELECT p FROM Person p"),
					@NamedQuery(name="person.getPersonById", query="SELECT p FROM Person p where p.id=:id")
				}
			 )
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int age;
	
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String name, int age){
	
		this.name = name;
		this.age = age;
	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getId() + "-" + getName() + "-" + getAge();
	}
	
	
	
	

}
