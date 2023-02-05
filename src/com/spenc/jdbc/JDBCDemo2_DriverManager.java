package com.spenc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @Classname: JDBCDemo2_DriverManager
 * @Author: spencerzhyp@gmail.com
 * @Date: 1/25/2023 8:11 PM
 */

public class JDBCDemo2_DriverManager {
    
    public static void main(String[] args) throws Exception {
        
        // 1. 注册驱动
        // Class.forName("com.mysql.jdbc.driver");
        // 2. 获取链接:如果链接的是本机MySQL并且端口是默认的3306可以简化书写
        String url = "jdbc:mysql:///db1";
        String username = "root";
        String password = "001207";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义SQL
        String sql = "update account set money = 2000 where id = 1";
        // 4. 获取执行SQL的对象Statement
        Statement stmt = conn.createStatement();
        // 5. 执行SQL
        int count = stmt.executeUpdate(sql);
        // 6. 处理结果
        System.out.println(count);
        // 7. 释放资源
        stmt.close();
        conn.close();
        
    }
}
