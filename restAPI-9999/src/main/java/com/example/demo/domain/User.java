package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//서버가 시작 할때 테이블 관련 어노테이션을 읽어서 테이블을 자동으로 만들어준다.
//서버 설정 파일은 application.propertis 파일 참고
@Entity
public class User {

	@Id														//pk 어노테이션
	@GeneratedValue(strategy = GenerationType.AUTO)			//자동증가
	private Long id;
	
	@Column(nullable=false, length = 20, unique = true)		//칼럼 설정
	private String userId;									//회원 아이디

	private String password;								//비번
	private String name;									//이름
	private String email;									//이메일
	
	
	//setter
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//getter
	
	public Long getId() {
		return id;
	}
	public String getUserId() {
		return userId;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	

	//회원 정보 업데이트 처리  함수
	public void update(User newUser) {
		this.password = newUser.password;
		this.name = newUser.name;
		this.email = newUser.email;
	}
	
	//회원 비밀번호 비교 처리 함수
	public boolean matchPassword(String newPassword) {
		if(newPassword == null) {
			return false;
		}
		return newPassword.equals(password);
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", email=" + email + "]";
	}

	
	
	
	
}
