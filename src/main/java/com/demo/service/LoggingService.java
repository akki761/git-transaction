package com.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LoggingService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.SUPPORTS)
    public void loggingIntoTransactionTable() {
        String sql = "INSERT into log (from_user,to_user,amount) VALUES (?,?,?)";
        jdbcTemplate.update(sql, new Object[]{1, 2, 2000});
        System.out.println("In Supports");
       // throw new RuntimeException();
    }



}
