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
	//@JoinColumn (foreignKey = @ForeignKey(name = "fk_question_writer"))
	
	@JoinColumn (name="user_id")
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

	@Override
	public String toString() {
		return "Question [id=" + id + ", writer=" + writer + ", title=" + title + ", contents=" + contents
				+ ", createDate=" + createDate + "]";
	}
	
}


/*

 비영속상태 :  셋팅만 한 상태 new Member();
 
 영속상태 : 맴버 객체 생성 후 엔티티 매니저를 얻어와서 콘텍스트에 멤버를 집어 넣는다.
 em.persistant(); //객체를 캐시에? 저장한 상태
 //db에 저장은 되지 않는다, 쿼리가 날라가지는 않는다.
 메니져가 끝나면 끝난다.(한 트랜잭션 범위)
 
 
 commit() 했을때 db로 날라간다.
 
 준영속: 콘텍스트에서 분리 
 
 첫번째 조회 할때 : db 에서 조회, 두번째: 1차캐시에서 가져옴. 
 
 db 조회 하면 무조건 영속성 컨텍스트에 올린다.


-영속 엔티티의 동일성 보장

jpa 영속엔티티의 동일성을 보장해준다.


-쓰기 지연

인서트 하면, 1차캐시에 넣고 , 쓰기지연 db에 쌓아둔다. db에 날라가는 시점은 commit을 했을때 . flush.


*/
