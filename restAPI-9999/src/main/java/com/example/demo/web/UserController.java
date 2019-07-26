
package com.example.demo.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;

@Controller					//controller 선언
@RequestMapping("/users")	//대표 url
public class UserController {

	//빈객체 : ui 에서 url 로 넘어온 key 값과 데이터 value 값을 담을 객체
	private List<User> users = new ArrayList<User>();
	
	
	//디비에 삽입할 인터페이스 : 스프링 부트에서 자동으로 생성 , 가져다 쓰기만 하면 된다.
	@Autowired
	private UserRepository userRepository;
	
	
	//가입화면
	@GetMapping("/form")
	public String form() {
		return "/user/form";
	}
	
	
	//가입
	@PostMapping("")
	public String create(User user) {
		System.out.print(user);
		//사용자 추가하기
		//users.add(user); //기존의 것
		userRepository.save(user); //jpa 라이브러리를 통해서 db저장
		return "redirect:/users";
	}
	
	//리스트
	@GetMapping("")
	public String list(Model model) {
		//전체유저 추가해서 화면에 던져주기
		//model.addAttribute("users", users); //기존방식
		model.addAttribute("users", userRepository.findAll());
		return "user/list";
	}
}
