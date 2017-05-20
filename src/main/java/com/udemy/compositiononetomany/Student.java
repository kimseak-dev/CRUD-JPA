package com.udemy.compositiononetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	
	@Column(name="student_name")
	private String studentName;
	
	@ManyToOne
	@JoinColumn(name ="unversityId")
	private University university;
	
	public University getUniversity() {
		return university;
	}


	public void setUniversity(University university) {
		this.university = university;
	}


	public Student(){
		
	}
	

	public Student(String studentName) {
		super();
		this.studentName = studentName;
	}


	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


}
