package org.kdu.homework.mapper;



import org.kdu.homework.entities.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getObject("id", UUID.class));
        user.setUserName(rs.getString("username"));
        user.setLoggedIn(rs.getShort("loggedin"));
        user.setCreatedAt(rs.getTimestamp("created_at"));
        user.setCreatedBy(rs.getString("created_by"));
        user.setUpdatedAt(rs.getTimestamp("updated_at"));
        user.setUpdatedBy(rs.getString("updated_by"));
        user.setTimeZone(rs.getString("time_zone"));
        user.setTenantId(rs.getObject("tenant_id", UUID.class));
        return user;
    }
}
