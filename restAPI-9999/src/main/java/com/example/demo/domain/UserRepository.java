package com.example.demo.domain;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//아래 api를 통해서 db에 데이터를 넣을 수 있다.

@Repository
//JpaRepository를 상속 받고 해당 데이터 모델의 vo, id의 타입을 기입
public interface UserRepository extends JpaRepository<User,Long>{
	
	//JPA 내장 쿼리 메소드를 직접 사용할 수 있고, 기존의 내장 메소드를 재정의 해서 사용할 수 있다.
	//JPA 메소드명을 만들때는 규칙이 있다. 구글링으로 확인!
	//로그인 할때 user ID 찾기 : userId를 기반으로 user 데이터를 조회할 수 있다.
	User findByUserId(String userId);
	User findById(Integer id);
}
