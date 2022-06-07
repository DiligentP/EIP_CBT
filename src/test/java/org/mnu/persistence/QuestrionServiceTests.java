package org.mnu.persistence;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mnu.domain.QuestionVO;
import org.mnu.mapper.QuestionMapper;
import org.mnu.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class QuestrionServiceTests {

    @Autowired
    QuestionMapper mapper;

    @Autowired
    QuestionService service;

    @Test
    public void getTest(){
        QuestionVO vo = mapper.get(1L,"w");
        log.info(vo.getComment());
    }

    @Test
    public void countTest(){
        String exam = "w";
        int count = service.getCount(exam);
        log.info(count);
    }
}
