package com.spenc.pojo;

/**
 * @Classname: Account
 * @Author: spencerzhyp@gmail.com
 * @Date: 1/26/2023 4:03 PM
 */
public class Account {
    
    private Integer id;
    private String name;
    private Double money;
    
    private Account() {
    
    }
    
    public Account(Integer id, String name, double money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }
    
    public Integer getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public double getMoney() {
        return money;
    }
    
    @Override
    public String toString() {
        return "Account{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", money=" + money +
            '}';
    }
}
