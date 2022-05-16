package org.mnu.persistence;


import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mnu.mapper.TimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {

    @Autowired
    private TimeMapper timeMapper;

    @Test
    public void testTime1() {
        log.info(timeMapper.getTime());
    }

    @Test
    public void testTime2() {
        log.info(timeMapper.getTime2());
    }

}
