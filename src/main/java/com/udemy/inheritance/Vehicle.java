package com.udemy.inheritance;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //single table
@Table(name ="vehicles")
//@DiscriminatorColumn(name="type")  //single table
//@Inheritance(strategy=InheritanceType.JOINED) //joint table
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vehicle {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	
	protected String name;
	
	public Vehicle(){
		
	}
	
	public Vehicle(String name){
		this.name = name;
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
	
	

}
