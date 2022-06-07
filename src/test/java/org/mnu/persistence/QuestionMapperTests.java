package org.mnu.persistence;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mnu.domain.QuestionVO;
import org.mnu.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}
