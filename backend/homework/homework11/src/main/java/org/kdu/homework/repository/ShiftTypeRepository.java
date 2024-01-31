package org.kdu.homework.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.kdu.homework.entities.ShiftType;
import org.kdu.homework.mapper.ShiftTypeRowMapper;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Repository
public class ShiftTypeRepository {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public ShiftTypeRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public UUID addShiftType(ShiftType shiftType) {
        UUID uuid = UUID.randomUUID();
        System.out.println(shiftType);
        String sql = "INSERT INTO shift_types (id, uq_name, description, active, created_at, created_by, updated_at, updated_by, time_zone, tenant_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, uuid, shiftType.getUniqueName(), shiftType.getDescription(), shiftType.isActive(), new Timestamp(System.currentTimeMillis()), shiftType.getCreatedBy(), new Timestamp(System.currentTimeMillis()), shiftType.getUpdatedBy(), shiftType.getTimeZone(), shiftType.getTenantId());
        return uuid;
    }

    public List<ShiftType> getAllShiftTypes(UUID tenantId) {
        String sql = "SELECT * FROM shift_types WHERE tenant_id = ?";
        return jdbcTemplate.query(sql, new Object[]{tenantId}, new ShiftTypeRowMapper());
    }
}
