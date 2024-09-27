package org.kdu.homework.repository;

import org.kdu.homework.entities.User;
import org.kdu.homework.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public UUID addUser(User user) {
        UUID uuid = UUID.randomUUID();
        String sql = "INSERT INTO users (id, username, loggedin, created_at, created_by, updated_at, updated_by, time_zone, tenant_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, uuid, user.getUserName(), user.getLoggedIn(), new Timestamp(System.currentTimeMillis()), user.getCreatedBy(), new Timestamp(System.currentTimeMillis()), user.getUpdatedBy(), user.getTimeZone(), user.getTenantId());
        return uuid;
    }

    public List<User> getAllUsers(UUID tenantId) {
        String sql = "SELECT * FROM users WHERE tenant_id = ?";
        return jdbcTemplate.query(sql, new Object[]{tenantId}, new UserRowMapper());
    }

    public void updateUser(UUID userId, User user){
        String sql = "UPDATE users SET username = ?, tenant_id = ?, updated_by = ?, updated_at = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getUserName(), user.getTenantId(), user.getUpdatedBy(), new Timestamp(System.currentTimeMillis()), userId);
    }
}
