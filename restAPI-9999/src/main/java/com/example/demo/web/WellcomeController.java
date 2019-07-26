package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//컨트롤러 클래스라는 의미 부여
@Controller
public class WellcomeController {

	@GetMapping("")
	public String wellcome() {
		

		return "index";
	}
	
}
