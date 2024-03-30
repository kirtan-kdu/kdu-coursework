package org.kdu.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.kdu.homework.entities.ShiftType;

import java.util.List;
import java.util.UUID;

@Repository
public interface ShiftTypeRepository extends JpaRepository<ShiftType, UUID> {

    List<ShiftType> findAllByTenantId(UUID tenantId);
}
