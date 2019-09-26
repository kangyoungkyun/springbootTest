package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	@Id
	@Column(name="no")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long no;
	
	@Column( name="name", nullable=false, length=100 )
	private String name;

	
	//카테고리와 책 엔티티는 다대다 관계 , 연관관계의 주인은 외래키를 가지고 있는 녀석.
	@OneToMany(mappedBy = "category")
	private List<Book> books = new ArrayList<Book>();
	
	
	
	
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	
	
	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Category() {}
	
	public Category(String name) {
		super();
		this.name = name;
	}
	
	//업데이트 처리  함수
	public void update(String newname) {
		this.name = newname;

	}
	
	
}