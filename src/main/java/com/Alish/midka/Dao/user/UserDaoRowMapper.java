package com.Alish.midka.Dao.user;

import com.Alish.midka.model.Product;
import com.Alish.midka.model.User;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoRowMapper  implements RowMapper<User> {


    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();

        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        return user;

    }
}
