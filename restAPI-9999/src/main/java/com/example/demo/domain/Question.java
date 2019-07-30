package com.example.demo.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	//질문에서 유저를 참조하게끔 질문(many) : 유저(one)    
	@ManyToOne
	@JoinColumn (foreignKey = @ForeignKey(name = "fk_question_writer"))
	private User writer;	//수정 후
	//private String writer; //관계 맵핑 수정전
	
	private String title;
	
	private String contents;
	
	private LocalDateTime createDate;
	
	//jpa를 사용하려면 기본 생성자를 만들어 줘야함
	public Question() {}
	
	public Question(User writer, String title, String contents) {
		super();
		this.writer = writer;
		this.title = title;
		this.contents = contents;
		this.createDate = LocalDateTime.now();
	}
	
	
	//날짜 변환 - 화면에서 호출 가능
	public String getFormattedCreatDate() {
		if(createDate == null) {
			return "";
		}
		
		return createDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
	}
	
}
