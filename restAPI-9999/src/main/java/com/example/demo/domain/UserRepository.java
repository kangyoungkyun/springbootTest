package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

//아래 api를 통해서 db에 데이터를 넣을 수 있다.
//사용 법은 UserController로 가서 AUTOWIRED
public interface UserRepository extends JpaRepository<User,Long>{

}
