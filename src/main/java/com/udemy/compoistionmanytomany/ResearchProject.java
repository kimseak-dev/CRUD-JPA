package com.udemy.compoistionmanytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="projects")
public class ResearchProject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="project_name")
	private String projectName;
	
	@ManyToMany
	@JoinTable(name="professor_project", 
				joinColumns = @JoinColumn(name="projectId"),
				inverseJoinColumns = @JoinColumn(name="professorId"))
	private List<Professor> professors;
	
	public ResearchProject(){
		this.professors = new ArrayList<Professor>(); //to avoid null pointer exception
		
	}
	
	public ResearchProject(String projectName){
		this();
		this.projectName = projectName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void assignProfessorToProject(Professor professor){
		this.professors.add(professor);
	}
	

}
