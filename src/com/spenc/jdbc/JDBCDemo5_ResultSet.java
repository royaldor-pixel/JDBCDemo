package com.spenc.jdbc;

import com.spenc.pojo.Account;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * @Classname: JDBCDemo5_ResultSet
 * @Author: spencerzhyp@gmail.com
 * @Date: 1/25/2023 11:11 PM
 */

public class JDBCDemo5_ResultSet {
    
    @Test
    public void testResultSet1() throws Exception {
        // 1. 注册驱动
        // Class.forName("com.mysql.jdbc.driver");
        // 2. 获取链接:如果链接的是本机MySQL并且端口是默认的3306可以简化书写
        String url = "jdbc:mysql://localhost/db1";
        String username = "root";
        String password = "001207";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义SQL
        String sql = "select * from account";
        // 4. 获取statement
        Statement stmt = conn.createStatement();
        // 5. 执行sql
        ResultSet rs = stmt.executeQuery(sql);
        // 6. 处理结果, 遍历rs中的所有数据
        // 6.1 光标向下移动一行, 并且判断当前行是否有数据
        // while (rs.next()) {
        // 6.2 获取数据 getXxx()
        //     Integer id = rs.getInt(1);
        //     String name = rs.getString(2);
        //     Double money = rs.getDouble(3);
        //
        //     System.out.println(id);
        //     System.out.println(name);
        //     System.out.println(money);
        //
        //     System.out.println("-----------");
        // }
        while (rs.next()) {
            // 6.2 获取数据 getXxx()
            Integer id = rs.getInt("id");
            String name = rs.getString("name");
            Double money = rs.getDouble("money");
            
            System.out.println(id);
            System.out.println(name);
            System.out.println(money);
            
            System.out.println("-----------");
        }
        
        // 7. 释放资源
        rs.close();
        stmt.close();
        conn.close();
    }
    
    @Test
    public void testResultSet2() throws Exception {
        // 1. 注册驱动
        // Class.forName("com.mysql.jdbc.driver");
        // 2. 获取链接:如果链接的是本机MySQL并且端口是默认的3306可以简化书写
        String url = "jdbc:mysql://localhost/db1";
        String username = "root";
        String password = "001207";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义SQL
        String sql = "select * from account";
        // 4. 获取statement
        Statement stmt = conn.createStatement();
        // 5. 执行sql
        ResultSet rs = stmt.executeQuery(sql);
        // 6. 处理结果, 遍历rs中的所有数据
        // 6.1 光标向下移动一行, 并且判断当前行是否有数据
        List<Account> accounts = new ArrayList<>();
        while (rs.next()) {
            // 6.2 获取数据 getXxx()
            Integer id = rs.getInt("id");
            String name = rs.getString("name");
            Double money = rs.getDouble("money");
            Account acc = new Account(id, name, money);
            accounts.add(acc);
        }
        System.out.println(accounts);
        
        // 7. 释放资源
        rs.close();
        stmt.close();
        conn.close();
    }
}
