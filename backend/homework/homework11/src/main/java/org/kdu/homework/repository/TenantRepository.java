package org.kdu.homework.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.kdu.homework.mapper.TenantRowMapper;
import org.kdu.homework.entities.Tenant;

import java.util.List;

@Repository
public class TenantRepository {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public TenantRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Tenant> getAllTenants(){
        String sql = "SELECT * FROM tenant";
        return jdbcTemplate.query(sql, new TenantRowMapper());
    }
}
