package org.kdu.homework.repository;

import org.kdu.homework.entities.ShiftUser;
import org.kdu.homework.mapper.ShiftUserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Repository
public class ShiftUserRepository {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public ShiftUserRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public UUID addShiftUser(ShiftUser shiftUser) {
        UUID uuid = UUID.randomUUID();
        String sql = "INSERT INTO shift_user (id, shift_id, user_id, created_at, created_by, updated_at, updated_by, tenant_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, uuid, shiftUser.getShiftId(), shiftUser.getUserId(), new Timestamp(System.currentTimeMillis()), shiftUser.getCreatedBy(), new Timestamp(System.currentTimeMillis()), shiftUser.getUpdatedBy(), shiftUser.getTenantId());
        return uuid;
    }

    public List<ShiftUser> getAllShiftUsers(UUID tenantId) {
        String sql = "SELECT * FROM shift_user WHERE tenant_id = ?";
        return jdbcTemplate.query(sql, new Object[]{tenantId}, new ShiftUserRowMapper());
    }
}
