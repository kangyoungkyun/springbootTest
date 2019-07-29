package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.QuestionRepository;

//컨트롤러 클래스라는 의미 부여
@Controller
public class WellcomeController {

	//퀘스쳔 리파지토리 사용
	@Autowired
	private QuestionRepository questionRepository;
	
	
	@GetMapping("")
	public String wellcome(Model model) {
		
		model.addAttribute("question", questionRepository.findAll());
		return "index";
	}
	
}
