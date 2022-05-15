package org.mnu.persistence;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

@Log4j
public class JDBCTests {

    @Test
    public void testConnection() throws Exception{

        // Oracle Driver Connection Test
        try {
            Class clz = Class.forName("oracle.jdbc.driver.OracleDriver");
            log.info(clz);
        }catch (Exception e){
            log.info(e + "Oracle Driver 연결 실패");
        }

        // Connection Oracle URL Test
        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@diligentp.com:1521:XE ","park","park");
            log.info(con);
        }catch (Exception e){
            log.info(e + "Connection Oracle URL 연결 실패");
        }
    }
}
