package org.mnu.controller;

import lombok.extern.log4j.Log4j;
import org.mnu.domain.MemberDTO;
import org.mnu.service.MemberService;
import org.mnu.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@Log4j
public class MemberController {

    @Autowired
    private MemberService service;

    // 로그인 요청
    //
    @PostMapping ("/login_confirm")
    public String login(String member_id, String member_password, HttpSession session){

        // 화면에서 입력한 아이디와 비밀번호가 일치하는 회원 정보가 DB에 있는지 확인
        MemberDTO dto = service.member_login(member_id, member_password);

        // 일치하는 회원정보가 있으면, 회원 정보를 세션에 담음.
        session.setAttribute("login_info",dto);

        return dto == null ? "login" : "index";
    }
}
