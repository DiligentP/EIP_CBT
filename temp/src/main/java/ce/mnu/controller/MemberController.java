package ce.mnu.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

import ce.mnu.service.*;
import ce.mnu.domain.*;

/**
 * 
 * @author DreStar
 * @brief 회원 관련 주소 처리
 * @details 회원과 관련된 주소에 접근하는 request를 처리한다.
 * @date 2022/05/24
 * @version 0.0.1
 *
 */

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/member/*")
public class MemberController {
	MemberService service;
	
	/**
	 * @brief 로그인 페이지
	 * @details /member/login으로 접근시 로그인 페이지를 보여준다.
	 */
	@GetMapping("/login")
	public void login() {

	}
	
	/**
	 * @brief 로그인 처리 페이지
	 * @details 입력한 정보로 DB와 일치하는 아이디와 비밀번호를 찾는다.
	 * 
	 * @param id 아이디
	 * @param pw 비밀번호
	 * @param rttr 리다이렉트
	 * @return 메인 페이지
	 */
	@PostMapping("/login")
	public String login(@RequestParam("id") String id, @RequestParam("pw") String pw, RedirectAttributes rttr) {
		return "redirect:/board/list";
	}
	
	/**
	 * @brief 마이 페이지
	 * @details 자신의 정보를 볼 수 있는 페이지를 보여준다.
	 */
	@GetMapping("/mypage")
	public void mypage() {

	}
	
	/**
	 * @brief 내 정보 수정 페이지
	 * @details 자신의 정보를 수정할 수 있는 페이지를 보여준다.
	 */
	@GetMapping("/modify")
	public void modify() {

	}
	
	/**
	 * @brief 내 정보 수정 처리 페이지
	 * @details 입력한 정보를 DB에 반영하여 정보를 수정한다.
	 */
	@PostMapping("/modify")
	public String modify(RedirectAttributes rttr) {
		return "redirect:/member/mypage";
	}
	
	/**
	 * @brief 회원 탈퇴 처리 페이지
	 * @details 회원탈퇴를 처리하고 메인페이지로 리다이렉트한다.
	 */
	@GetMapping("/quit")
	public String quit(RedirectAttributes rttr) {
		return "redirect:/";
	}
	
	/**
	 * @brief 관리자 전용 회원 리스트 페이지
	 * @details 관리자 전용 회원 리스트 페이지
	 */
	@GetMapping("/list")
	public void list() {
		
	}
}