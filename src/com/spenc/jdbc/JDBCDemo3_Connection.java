package com.spenc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @Classname: JDBCDemo3_Connection
 * @Author: spencerzhyp@gmail.com
 * @Date: 1/25/2023 8:11 PM
 */

public class JDBCDemo3_Connection {
    
    public static void main(String[] args) throws Exception {
        
        // 1. 注册驱动
        // Class.forName("com.mysql.jdbc.driver");
        // 2. 获取链接:如果链接的是本机MySQL并且端口是默认的3306可以简化书写
        String url = "jdbc:mysql://localhost:3306/db1";
        String username = "root";
        String password = "001207";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义SQL
        String sql1 = "update account set money = 1000 where id = 1";
        String sql2 = "update account set money = 800 where id = 2";
        // 4. 获取执行SQL的对象Statement
        Statement stmt = conn.createStatement();
        try {
            // 开启事务
            conn.setAutoCommit(false);
            // 5. 执行SQL
            int count1 = stmt.executeUpdate(sql1);
            // 6. 处理结果
            System.out.println(count1);
            // 5. 执行SQL
            int count2 = stmt.executeUpdate(sql2);
            // 6. 处理结果
            System.out.println(count2);
            // 提交事务
            conn.commit();
        } catch (Exception e) {
            // 回滚事务
            conn.rollback();
            System.out.println("rollback");
        }
        // 7. 释放资源
        stmt.close();
        conn.close();
        
        
    }
}
