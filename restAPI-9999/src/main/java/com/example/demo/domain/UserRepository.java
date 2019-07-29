package com.example.demo.domain;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//아래 api를 통해서 db에 데이터를 넣을 수 있다.

@Repository
//vo, id의 타입
public interface UserRepository extends JpaRepository<User,Long>{

	//로그인 할때 user ID 찾기 : userId를 기반으로 user 데이터를 조회할 수 있다.
	User findByUserId(String userId);
	User findById(Integer id);
}
