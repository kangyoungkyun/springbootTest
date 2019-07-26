package com.example.demo.domain;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//아래 api를 통해서 db에 데이터를 넣을 수 있다.

@Repository
public interface UserRepository extends JpaRepository<User,Long>{


}
