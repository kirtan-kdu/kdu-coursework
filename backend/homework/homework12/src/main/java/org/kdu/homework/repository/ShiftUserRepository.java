package org.kdu.homework.repository;

import org.kdu.homework.entities.ShiftUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;


@Repository
public interface ShiftUserRepository extends JpaRepository<ShiftUser, UUID> {

    List<ShiftUser> findAllByTenantId(UUID tenantId);

}
