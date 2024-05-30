package org.example.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class UserRepo {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertUser(User user) {
        String sql = "insert into users (username, name, password) values (?, ?, ?)";
        return jdbcTemplate.update(sql,user.getUsername(),user.getName(),user.getPassword());
    }

    public int updateUser(User user) {
        String sql = "update users set name = ?, password = ? where username = ?";
        return jdbcTemplate.update(sql,user.getName(),user.getPassword(),user.getUsername());
    }

    public int deleteUser(String username) {
        String sql = "delete from users where username = ?";
        return jdbcTemplate.update(sql,username);
    }

    public User getUser(String username) {
        String sql = "select * from users where username = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        List<User> list= jdbcTemplate.query(sql,rowMapper,username);
        return list.getFirst();
    }

    public List<User> getAllUsers() {
        String sql = "select * from users";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.query(sql,rowMapper);
    }
}
