package org.mnu.controller;

import lombok.extern.log4j.Log4j;
import org.mnu.domain.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@Log4j
public class MainController {
	
	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("test", "박건웅");

		return "index";
	}


	@GetMapping("/login")
	public String login(@ModelAttribute("user") UserDTO dto) {
		log.info(dto);
		log.info(dto.getLoginId());
		if(dto.getLoginId()==null){
			return "login";
		}
		else {
			log.info(dto);
			return "test";
		}
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@GetMapping("/re1")
	public String rel1() {
		log.info("rel1................");

		return "redirect:/re2";
	}

	@GetMapping("/re2")
	public void rel2() {
		log.info("rel2................");
	}
}
