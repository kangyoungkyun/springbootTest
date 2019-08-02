package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.Question;
import com.example.demo.domain.QuestionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//컨트롤러 클래스라는 의미 부여
@Controller
//메인 컨트롤러
public class WellcomeController {

	//퀘스쳔 리파지토리 사용
	@Autowired
	private QuestionRepository questionRepository;
	
	//메인 화면으로 이동
	@GetMapping("")
	public String wellcome(Model model) {
		
		
		System.out.println("메인화면");
		
		
		List<Question> questions = questionRepository.findAll();
		

		
		  for (Question question : questions) {
			  
		  System.out.println(question.toString()); 
		  }
		
		
		model.addAttribute("question", questionRepository.findAll());
		return "index";
	}
	
}
