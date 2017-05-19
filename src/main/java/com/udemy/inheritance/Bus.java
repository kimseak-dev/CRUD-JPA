package com.udemy.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue(value = "B") //single table
@Table(name="bus")
//@PrimaryKeyJoinColumn(referencedColumnName="id") //joint table
//Table_Per_Concrete_Class
public class Bus extends Vehicle {

	private int numberOfPassengers;

	public Bus() {

	}

	public Bus(String name, int numberOfPassengers) {
		super(name);
		this.numberOfPassengers = numberOfPassengers;
	}

	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}

	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}
}
