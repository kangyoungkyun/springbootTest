package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name="book")
public class Book {
	@Id
	@Column(name="no")
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long no;
	
	@Column(name="title", nullable=false, length=200)
	private String title;
	
	@ManyToOne
	@JoinColumn(name ="category_no")
	private Category category;

	
	public Book() {}
	
	public Book(String title, Category category) {
		super();
		this.title = title;
		this.category = category;
	}
	

	public Long getNo() {
		return no;
	}

	public String getTitle() {
		return title;
	}

	public Category getCategory() {
		return category;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	// getter , setter 생략
	//업데이트 처리  함수
	public void update(String newname, Category newCategory) {
		this.title = newname;
		this.category = newCategory;

	}
	
}