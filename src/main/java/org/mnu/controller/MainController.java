package org.mnu.controller;

import lombok.extern.log4j.Log4j;
import org.mnu.domain.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Log4j
public class MainController {
	
	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("test", "박건웅");

		return "index";
	}

	@PostMapping("/login")
	public void login(UserDTO dto) {
		log.info(dto);
	}
	
}
