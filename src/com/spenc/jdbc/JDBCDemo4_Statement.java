package com.spenc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Classname: JDBCDemo4_Statement
 * @Author: spencerzhyp@gmail.com
 * @Date: 1/25/2023 8:11 PM
 */

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
        // String sql = "update account set money = 2000 where id = 5";
        String sql1 = "create database if not exists db2";
        String sql2 = "drop database if exists db2";
        // 4. 获取执行SQL的对象Statement
        Statement stmt = conn.createStatement();
        // 5. 执行SQL
        int count = stmt.executeUpdate(sql2); // 执行完DML语句后受影响的行数, 可能是0
        // 6. 处理结果
        if (count > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
        // 7. 释放资源
        stmt.close();
        conn.close();
        // Assert.assertEquals(count, 0);
        
    }
    
    @Test
    public void testDDL() {
    
    }
}
