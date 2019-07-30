package com.example.demo.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Question;
import com.example.demo.domain.QuestionRepository;
import com.example.demo.domain.User;

//1.컨트롤러 클래스인것을 알려줌
@Controller
//2.대표 URL
@RequestMapping("questions")
public class QuestionController {

	//question 리파지토리를 사용하겠다!
	@Autowired
	private QuestionRepository questionRepository;
	
	
	//질문 페이지 보기
	@GetMapping("/form")
	public String form(HttpSession session) {
		
		//로그인이 안됐으면
		if(!HttpSessionUtil.isLoginUser(session)) {
			return "/users/loginForm";
		}
		
		return "/qna/form";
	}
	
	
	//질문 작성
	@PostMapping("")
	public String create(String title, String contents,HttpSession session) {
		if(!HttpSessionUtil.isLoginUser(session)) {
			return "/users/loginForm";
		}
		
		User sessionUser = HttpSessionUtil.getUserFromSession(session);
		//객체에서 데이터 꺼내기 x, 객체를 전달하게끔 코딩하라
		Question newQuestion = new Question(sessionUser, title, contents);
		questionRepository.save(newQuestion);
		
		return "redirect:/";
	}
	
	
}
