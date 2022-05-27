package org.mnu.persistence;


import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.mnu.domain.*;
import org.mnu.mapper.*;
import org.mnu.service.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberMapperTests {

    @Autowired
    private MemberService service;

    @Autowired
    private MemberMapper mapper;

    @Test
    public void testSelectUser() {

        // 화면에서 입력한 아이디와 비밀번호가 일치하는 회원 정보가 DB에 있는지 확인
        MemberVO vo = service.member_login("park", "park");

        log.info(vo);
    }

    @Test
    public void testInsertUser() {

        MemberVO vo = new MemberVO();
        vo.setMember_id("kim");
        vo.setMember_password("kim");
        vo.setMember_email("kim@naver.com");
        vo.setMember_name("김개똥");
        log.info(".........................................................");
        int result = service.member_register(vo);
        log.info(result);
    }

    @Test
    public void testSelectUserId() {
        int result = mapper.selectUserId("hong");

        log.info("------------------------------------------------------------");
        log.info("result : "+result);

    }
}
