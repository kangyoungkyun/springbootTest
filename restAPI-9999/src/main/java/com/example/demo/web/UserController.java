
package com.example.demo.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	
	//가입 + session
	@PostMapping("")
	public String create(User user,HttpSession session) {
		System.out.print(user);
		//사용자 추가하기
		//users.add(user); //기존의 것
		userRepository.save(user); //jpa 라이브러리를 통해서 db저장
		session.setAttribute(HttpSessionUtil.USER_SESSION_KEY, user);
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
	
	
	//수정하기/ 폼 + 세션 체크 
	@GetMapping("/{id}/form")
	public String updateForm(@PathVariable Integer id, Model model,HttpSession session) {
		
		//로그인 안되어 있으면 가입 폼으로 이동
		//Object obj = session.getAttribute(HttpSessionUtil.USER_SESSION_KEY);
		//if(obj == null) {
		//	return "redirect:/users/form";
		//}
		
		// - 객체 지향으로 변경: 객체에게 비번이 다른지 체크요청
		if(!HttpSessionUtil.isLoginUser(session)) {
			return "redirect:/users/form";
		}
		
		
		//자신이 아닐 경우 에러 메시지 던지기
		//User sessionedUser = (User)obj;
		
		User sessionedUser	= HttpSessionUtil.getUserFromSession(session);
		
		if(!id.equals(sessionedUser.getId())) {
			System.out.println("자신의 정보만 수정할 수 있습니다.");
			throw new IllegalStateException("you can't update another users's data!!");
		}
		
		System.out.println("수정하기");
		System.out.println(id);
		System.out.println(id instanceof Integer);
		
		User user = userRepository.findById(sessionedUser.getId());
		
		System.out.println(user);
		
		model.addAttribute("userModify", user);
		return "user/updateForm";
	}
	
	//수정하기/DB 추가
	@PutMapping("/{id}")
	public String update(@PathVariable Integer id, User newUser,HttpSession session) {
		
		//로그인 안되어 있으면 가입 폼으로 이동
				Object obj = session.getAttribute(HttpSessionUtil.USER_SESSION_KEY);
				if(obj == null) {
					return "redirect:/users/form";
				}
				
				//자신이 아닐 경우 에러 메시지 던지기
				User sessionedUser = (User)obj;
				if(!id.equals(sessionedUser.getId())) {
					System.out.println("자신의 정보만 수정할 수 있습니다.");
					throw new IllegalStateException("you can't update another users's data!!");
				}
		
		User user = userRepository.findById(sessionedUser.getId());
		user.update(newUser);
		userRepository.save(user); //기존에 있으면 업데이트 , 없으면 추가
		
		return "redirect:/users";
	}
	
	//login폼 이동
	@GetMapping("/loginForm")
	public String loginForm() {
		
		return "user/login";
	}
	
	
	
	//login + SESSION 에 저장
	@PostMapping("/login")
	public String login(String userId, String password ,HttpSession session) {
		
		//id 로 조회
		User user = userRepository.findByUserId(userId);
		
		//가입한 사람이 X
		if(user == null) {
			System.out.println("login fail");
			return "redirect:/users/loginForm";
		}
		
		//비밀번호가 다를때 - 기존
//		if(!password.equals(user.getPassword())) {
//			System.out.println("login fail");
//			return "redirect:/users/loginForm";
//		}
		
		//비밀번호가 다를때 - 객체 지향으로 변경: 객체에게 비번이 다른지 체크요청
		//getPassword () 메소드를 사용하는것이 아니라 .. 다른 커스텀 메소드 사용.
		if(user.matchPassword(password)) {
			System.out.println("login fail");
			return "redirect:/users/loginForm";
		}
		
		System.out.println("login success");		
		session.setAttribute(HttpSessionUtil.USER_SESSION_KEY, user);
		return "redirect:/";
	}
	
	
	
	//logout
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute(HttpSessionUtil.USER_SESSION_KEY);
		return "redirect:/";
	}
	
	
	
	
}
