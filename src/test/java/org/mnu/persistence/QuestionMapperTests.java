package org.mnu.persistence;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mnu.domain.QuestionResultVO;
import org.mnu.domain.QuestionVO;
import org.mnu.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class QuestionMapperTests {

    @Autowired
    QuestionMapper mapper;

    @Test
    public void QuestionGetTest(){

        QuestionVO a = mapper.get(1L,"w");
        log.info("-------------------------------------------------------");
        log.info(a);
        log.info("-------------------------------------------------------");
    }

    @Test
    public void QuestionGetListTest(){

        List<QuestionVO> a = mapper.getList();
        log.info("-------------------------------------------------------");
        log.info(a);
        log.info("-------------------------------------------------------");

    }

    @Test
    public void QuestionGetListWriterTest(){

        List<QuestionVO> a = mapper.getListWriter("park");
        log.info("-------------------------------------------------------");
        log.info(a);
        log.info("-------------------------------------------------------");

    }
    @Test
    public void QuestionGetCountTest() {

        int a = mapper.getCount("w");
        log.info("-------------------------------------------------------");
        log.info(a);
        log.info("-------------------------------------------------------");

    }

    @Test
    public void QuestionUpdateTest(){
        QuestionVO vo = mapper.get(2L,"w");
        log.info("-------------------------------------------------------");
        log.info(vo);
        log.info("-------------------------------------------------------");

        vo.setTitle("코드 설계에서 일정한 일련번호를 부여하는 방식의 코드는?");
        vo.setContent1("연상 코드");
        vo.setContent2("블록 코드");
        vo.setContent3("순차 코드");
        vo.setContent4("표의 숫자 코드");
        vo.setAnswer("3");
        vo.setComment("연상코드 : 코드화 대상 항목의 명칭이나 약호와 관계있는 숫자나 문자, 기호를 이용하여 코드를 부여하는 방법블록코드 : 코드화 대상 항목 중에서 공통성이 있는 것끼리 블록으로 구분하고, 각 블록 내에서 일련번호를 부여하는 방법 (=구분코드)표의 숫자 코드 : 코드화 대상 항목의 성질, 물리적 수치를 그대로 코드에 적용시키는 방법 (=유효숫자코드)");

        int a = mapper.update(vo);
        log.info("-------------------------------------------------------");
        log.info(a);
        log.info("-------------------------------------------------------");
    }

    @Test
    public void QuestionInsertTest() {
        QuestionVO vo = new QuestionVO();

        int a = mapper.getCount("w");
        vo.setQno((long) a+1);
        vo.setTitle("test");
        vo.setContent1("보기1");
        vo.setContent2("보기2");
        vo.setContent3("보기3");
        vo.setContent4("보기4");
        vo.setComment("코멘트");
        vo.setAnswer("1");
        vo.setWriter("park");

        int b = mapper.insert(vo);
    }

    @Test
    public void QuestionResultTest(){
        QuestionResultVO vo = new QuestionResultVO();
        vo.setMember_id("park");
        vo.setAnswer(5);
        vo.setCount(10);

        int a = mapper.insertResult(vo);
    }

    @Test
    public void getResultListTest(){
        List<QuestionResultVO> vo = mapper.getResultList("park");

        log.info(vo);
    }
}
