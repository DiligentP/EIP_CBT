package org.mnu.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {

    @Autowired
    private DataSource ds;

    @Test
    public void testConnection() throws Exception{

        try(Connection con = ds.getConnection()){
            log.info("Hikariconfig Connection Pool 성공");
        }catch (Exception e){
            log.info(e + "Hikariconfig Connection Pool 실패");
        }
    }
}
