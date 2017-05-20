package com.udemy.compositiononetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class University {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="Id")
	private int universityId;
	
	@Column(name="university_name")
	private String universityName;
	
	@OneToMany(mappedBy="university")
	private List<Student> students;
	
	public University(){
		this.students = new ArrayList<Student>();
	}
	
	public University(String universityName){
		this();
		this.universityName = universityName;
	}
	
	public void addStudent(Student student){
		this.students.add(student);
	}
	

}
