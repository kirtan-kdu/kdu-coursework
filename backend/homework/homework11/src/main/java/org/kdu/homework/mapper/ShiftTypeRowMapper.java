package org.kdu.homework.mapper;


import org.kdu.homework.entities.ShiftType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ShiftTypeRowMapper implements RowMapper<ShiftType> {
    @Override
    public ShiftType mapRow(ResultSet rs, int rowNum) throws SQLException {
        ShiftType shiftType = new ShiftType();
        shiftType.setId(rs.getObject("id", UUID.class));
        shiftType.setUniqueName(rs.getString("uq_name"));
        shiftType.setDescription(rs.getString("description"));
        shiftType.setActive(rs.getBoolean("active"));
        shiftType.setCreatedAt(rs.getTimestamp("created_at"));
        shiftType.setCreatedBy(rs.getString("created_by"));
        shiftType.setUpdatedAt(rs.getTimestamp("updated_at"));
        shiftType.setUpdatedBy(rs.getString("updated_by"));
        shiftType.setTimeZone(rs.getString("time_zone"));
        shiftType.setTenantId(rs.getObject("tenant_id", UUID.class));
        return shiftType;
    }
}
