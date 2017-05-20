package com.udemy.callback;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@EntityListeners(ArticleListener.class)
public class Article {
	
	@Id
	@Column(name="article_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="aritcle_name")
	private String articleName;
	
	@Column(name="article_date")
	private Date date;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Article() {
		// TODO Auto-generated constructor stub
	}
	
	public Article( String aritcleName) {
		this.articleName = aritcleName;
	}
	
}
