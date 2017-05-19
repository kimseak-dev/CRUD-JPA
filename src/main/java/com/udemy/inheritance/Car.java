package com.udemy.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="car") 
//@DiscriminatorValue(value="C") //for single table
//@PrimaryKeyJoinColumn(referencedColumnName="id") //joint table
//Table_Per_Concrete_Class
public class Car extends Vehicle {
	
	private int speed;

	public Car() {
		
	}

	public Car(String name, int speed) {
		super(name);
		this.speed = speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getSpeed() {
		return speed;
	}
	
	
	

}
