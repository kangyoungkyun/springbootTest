package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//테이블이 자동으로 만들어진다.

@Entity
public class User {

	@Id						//pk
	@GeneratedValue			//자동증가
	private Long id;
	
	@Column(nullable=false, length = 20)	//널값 방지
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
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", email=" + email + "]";
	}
	
	
	
	
}
