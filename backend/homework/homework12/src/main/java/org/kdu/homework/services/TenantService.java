package org.kdu.homework.services;

import lombok.extern.slf4j.Slf4j;
import org.kdu.homework.entities.Tenant;
import org.kdu.homework.exceptions.custom.CustomException;
import org.kdu.homework.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class TenantService {

    private final TenantRepository tenantRepository;

    @Autowired
    public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    public void addTenant(Tenant tenant) {
        try {
            tenantRepository.save(tenant);
            log.info("Tenant added Successfully");
        } catch (Exception e) {
            throw new CustomException("Invalid tenant id");
        }
    }
    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

}
