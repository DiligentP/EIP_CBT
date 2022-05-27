package org.mnu.persistence;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.mnu.domain.*;
import org.mnu.mapper.BoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {


    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void testGetList() {
        log.info("---------------------------");
        log.info(boardMapper.getList());
        boardMapper.getList().forEach(board -> log.info(board));
    }

    @Test
    public void testInsert() {
        BoardVO vo = new BoardVO();
        vo.setTitle("Test 테스트");
        vo.setContent("Content 테스트");
        vo.setWriter("tester");

        boardMapper.insert(vo);
    }

    @Test
    public void testInsertSelectKey(){
        BoardVO vo = new BoardVO();
        vo.setTitle("AAATest 테스트");
        vo.setContent("AAAContent 테스트");
        vo.setWriter("tester");

        boardMapper.insertSelectKey(vo);
    }

    @Test
    public void testRead(){
        BoardVO vo = boardMapper.read(21L);
        log.info(vo);
    }

    @Test
    public void testDelete() {
        int count = boardMapper.delete(21L);
        log.info(count);
    }

    @Test
    public void testUpdate() {
        BoardVO vo  = new BoardVO();
        vo.setBno(1L);
        vo.setTitle("Update Title");
        vo.setContent("Update content");
        vo.setWriter("user00");

        log.info("Count: " + boardMapper.update(vo));
    }
}
