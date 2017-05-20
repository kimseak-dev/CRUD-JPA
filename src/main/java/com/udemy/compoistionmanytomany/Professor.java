package com.udemy.compoistionmanytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="professors")
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="professor_name")
	private String professorName;
	
	@ManyToMany(mappedBy="professors")
	private List<ResearchProject> projects;
	
	public Professor(){
		this.projects = new ArrayList<ResearchProject>(); // avoid null pointer exception 
	}
	
	public Professor(String professorName){
		this();
		this.professorName = professorName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	
	public void assignProjectToProcessor(ResearchProject project){
		this.projects.add(project);
		
	}

}
