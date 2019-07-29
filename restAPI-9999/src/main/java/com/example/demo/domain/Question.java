package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Question {

	@Id
	@GeneratedValue
	private Long id;
	
	private String writer;
	
	private String title;
	
	private String contents;
	
	//jpa를 사용하려면 기본 생성자를 만들어 줘야함
	public Question() {}
	
	public Question(String writer, String title, String contents) {
		super();
		this.writer = writer;
		this.title = title;
		this.contents = contents;
	}
	
}
