package com.spenc.jdbc;

import com.spenc.pojo.Account;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * @Classname: JDBCDemo7_PreparedStatement
 * @Author: spencerzhyp@gmail.com
 * @Date: 1/26/2023 4:21 PM
 */
public class JDBCDemo7_PreparedStatement {
    
    
    @Test
    public void testResultSet1() throws Exception {
        // 1. 注册驱动
        // Class.forName("com.mysql.jdbc.driver");
        // 2. 获取链接:如果链接的是本机MySQL并且端口是默认的3306可以简化书写
        String url = "jdbc:mysql://localhost/db1&useServerPrepStmts=true";
        String username = "root";
        String password = "001207";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义SQL
        String sql = "select * from accounts where username = ? and password = ?";
        // 4. 获取pstmt
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();
        
        rs.close();
        pstmt.close();
        conn.close();
    }
    
}
