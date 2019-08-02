package com.example.demo.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
//vo, id의 타입
public interface BookRepository extends JpaRepository<Book,Long>{

	
}
