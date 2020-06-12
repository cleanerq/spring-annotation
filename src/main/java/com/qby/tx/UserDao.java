package com.qby.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author qby
 * @date 2020/6/12 19:58
 */

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert() {
        String sql = "INSERT into tbl_user(username, age) VALUES(?,?)";
        String username = UUID.randomUUID().toString().substring(0, 5);

        jdbcTemplate.update(sql, username, 19);
    }
}
