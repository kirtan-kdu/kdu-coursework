package org.kdu.homework.services;

import org.kdu.homework.entities.Tenant;
import org.kdu.homework.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantService {

    private final TenantRepository tenantRepository;

    @Autowired
    public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    public List<Tenant> getAllTenants(){
        return tenantRepository.getAllTenants();
    }

}
