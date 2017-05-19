package com.udemy.mapped;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractCitizen {
	
	protected String drivingLicence;
	
	public AbstractCitizen(){
		
	}
	

	public void setDrivingLicence(String drivingLicence) {
		this.drivingLicence = drivingLicence;
	}
	public String getDrivingLicence() {
		return drivingLicence;
	}
	

}
