package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//vo, id의 타입
public interface QuestionRepository extends JpaRepository<Question,Long>{

}
