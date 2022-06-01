package org.mnu.controller;

import lombok.extern.log4j.Log4j;
import org.mnu.domain.MemberVO;
import org.mnu.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@Log4j
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    // 로그인 요청
    @PostMapping ("/login_confirm")
    public String login(String member_id, String member_password, HttpSession session){

        // 화면에서 입력한 아이디와 비밀번호가 일치하는 회원 정보가 DB에 있는지 확인
        MemberVO vo = service.member_login(member_id, member_password);

        // 일치하는 회원정보가 있으면, 회원 정보를 세션에 담음.
        session.setAttribute("login_info",vo);

        return vo == null ? "login" : "index";
    }
    
    //로그아웃 요청
    @GetMapping("/logout")
    public String logout(HttpSession session){
        
        // 세션을 비움
        session.invalidate();

        return "index";
    }

    // 회원가입 요청
    @PostMapping("/register_confirm")
    public String register(MemberVO vo){

        // 회원가입 요청
        Integer result =  service.member_register(vo);

        return result.equals(1) ? "login" : "register";
    }

    @PostMapping("/idCheck")
    @ResponseBody
    public int idCheck(@RequestParam("id") String id){
        log.info("userIdCheck 진입");
        log.info("전달받은 id:"+id);
        int result = service.member_idcheck(id);
        log.info("확인 결과:"+result);
        return result;
    }

}
