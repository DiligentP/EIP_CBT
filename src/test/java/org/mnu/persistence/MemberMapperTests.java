package org.mnu.persistence;


import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mnu.domain.MemberDTO;
import org.mnu.mapper.MemberMapper;
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

    @Autowired
    private MemberMapper mapper;

    @Test
    public void testSelectUser() {

        // 화면에서 입력한 아이디와 비밀번호가 일치하는 회원 정보가 DB에 있는지 확인
        MemberDTO dto = service.member_login("park", "park");

        log.info(dto);
    }

    @Test
    public void testInsertUser() {

        MemberDTO dto = new MemberDTO();
        dto.setMember_id("kim");
        dto.setMember_password("kim");
        dto.setMember_email("kim@naver.com");
        dto.setMember_name("김개똥");
        log.info(".........................................................");
        int result = service.member_register(dto);
        log.info(result);
    }

    @Test
    public void testSelectUserId() {
        int result = mapper.selectUserId("hong");

        log.info("------------------------------------------------------------");
        log.info("result : "+result);

    }
}
