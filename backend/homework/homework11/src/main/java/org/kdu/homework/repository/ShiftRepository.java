package org.kdu.homework.repository;

import org.kdu.homework.entities.Shift;
import org.kdu.homework.mapper.ShiftRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Repository
public class ShiftRepository {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public ShiftRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public UUID addShift(Shift shift) {
        UUID uuid = UUID.randomUUID();
        String sql = "INSERT INTO shifts (id, shift_type_id, name, date_start, date_end, time_start, time_end, created_at, created_by, updated_at, updated_by, time_zone, tenant_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, uuid , shift.getShiftTypeId(), shift.getName(), shift.getStartDate(), shift.getEndDate(), shift.getStartTime(), shift.getEndTime(), new Timestamp(System.currentTimeMillis()), shift.getCreatedBy(), new Timestamp(System.currentTimeMillis()), shift.getUpdatedBy(), shift.getTimezone(), shift.getTenantId());
        return uuid;
    }

    public List<Shift> getAllShifts(UUID tenantId) {
        String sql = "SELECT * FROM shifts WHERE tenant_id = ?";
        return jdbcTemplate.query(sql, new Object[]{tenantId}, new ShiftRowMapper());
    }
}