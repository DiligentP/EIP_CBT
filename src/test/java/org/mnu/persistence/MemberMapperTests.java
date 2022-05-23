package org.mnu.persistence;


import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mnu.domain.MemberDTO;
import org.mnu.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberMapperTests {

    @Autowired
    private MemberService service;

    @Test
    public void MemberMapperTest() {

        // 화면에서 입력한 아이디와 비밀번호가 일치하는 회원 정보가 DB에 있는지 확인
        MemberDTO dto = service.member_login("park", "park");

        log.info(dto);
    }
}