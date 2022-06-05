package org.mnu.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Log4j
@RequestMapping("/*")
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/main")
	public String main() {
		return "main";
	}

	@GetMapping("/login")
	public String login(){ return "login"; }

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@GetMapping("/practical")
	public String practical() {
		return "practical";
	}

	@GetMapping("/written")
	public String written(Model model) {
		return "written";
	}
	@GetMapping("/mypage")
	public String mypage() {
		return "mypage";
	}


}
