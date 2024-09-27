package org.kdu.homework.mapper;

import org.kdu.homework.entities.ShiftUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ShiftUserRowMapper implements RowMapper<ShiftUser> {
    @Override
    public ShiftUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        ShiftUser shiftUser = new ShiftUser();
        shiftUser.setId(rs.getObject("id", UUID.class));
        shiftUser.setShiftId(rs.getObject("shift_id", UUID.class));
        shiftUser.setUserId(rs.getObject("user_id", UUID.class));
        shiftUser.setCreatedAt(rs.getTimestamp("created_at"));
        shiftUser.setCreatedBy(rs.getString("created_by"));
        shiftUser.setUpdatedAt(rs.getTimestamp("updated_at"));
        shiftUser.setUpdatedBy(rs.getString("updated_by"));
        shiftUser.setTenantId(rs.getObject("tenant_id", UUID.class));
        return shiftUser;
    }
}
