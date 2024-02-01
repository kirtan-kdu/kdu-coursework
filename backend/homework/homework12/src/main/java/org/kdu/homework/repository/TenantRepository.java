package org.kdu.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.kdu.homework.entities.Tenant;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, UUID> {


}
