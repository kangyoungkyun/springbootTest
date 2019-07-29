package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//테이블이 자동으로 만들어진다.

@Entity
public class User {

	@Id						//pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)			//자동증가
	private int id;
	
	@Column(nullable=false, length = 20, unique = true)	//널값 허용
	private String userId;	
	
	private String password;
	private String name;
	private String email;
	
	
	
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
	
	
	
	
	
	public int getId() {
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
	
	
	//회원 업데이트
	public void update(User newUser) {
		this.password = newUser.password;
		this.name = newUser.name;
		this.email = newUser.email;
		
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", email=" + email + "]";
	}

	
	
	
	
}
