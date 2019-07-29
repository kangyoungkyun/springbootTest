package com.example.demo.web;

import javax.servlet.http.HttpSession;

import com.example.demo.domain.User;

//세션 관리 클래스
public class HttpSessionUtil {

	//세션 상수 
	public static final String USER_SESSION_KEY = "user";
	
	//로그인 유무 메서드
	public static boolean isLoginUser(HttpSession session) {
		
	Object obj =session.getAttribute(USER_SESSION_KEY);
	if(obj == null) {
		return false;	
	}	
		return true;
	}
	
	//현재 로그인한 유저 체크
	public static User getUserFromSession(HttpSession session) {
		
		if(!isLoginUser(session)) {
			return null;
		}
		
		return (User)session.getAttribute(USER_SESSION_KEY);
	}
	
}
