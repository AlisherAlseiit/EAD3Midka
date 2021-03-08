package com.Alish.midka.Dao.user;

import com.Alish.midka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public User checkAdmin(String name, String password){
        return jdbcTemplate.query("SELECT * FROM Admin WHERE name=? and password=?", new Object[]{name, password}, new UserDaoRowMapper())
                .stream().findAny().orElse(null);
    }

    public User checkUser(String name, String password){
        return  jdbcTemplate.query("SELECT * FROM Registration WHERE name=? and password=?", new Object[]{name, password}, new UserDaoRowMapper())
                .stream().findAny().orElse(null);
    }

    public void registerUser(String name, String password ){
        jdbcTemplate.update("INSERT INTO Registration( name, password)  VALUES (?,?)", name, password);
    }

}
