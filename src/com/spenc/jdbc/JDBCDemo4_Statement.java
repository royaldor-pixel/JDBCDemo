package com.spenc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.junit.Assert;
import org.junit.Test;

public class JDBCDemo4_Statement {
    
    @Test
    public void testDML() throws Exception {
        // 1. 注册驱动
        // Class.forName("com.mysql.jdbc.driver");
        // 2. 获取链接:如果链接的是本机MySQL并且端口是默认的3306可以简化书写
        String url = "jdbc:mysql://localhost/db1";
        String username = "root";
        String password = "001207";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义SQL
        String sql = "update account set money = 2000 where id = 5";
        // 4. 获取执行SQL的对象Statement
        Statement stmt = conn.createStatement();
        // 5. 执行SQL
        int count = stmt.executeUpdate(sql); // 执行完DML语句后受影响的行数
        // 6. 处理结果
        System.out.println(count);
        // 7. 释放资源
        stmt.close();
        conn.close();
        Assert.assertEquals(count, 0);
    }
}
