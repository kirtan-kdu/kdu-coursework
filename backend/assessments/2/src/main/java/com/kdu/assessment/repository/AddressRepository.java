package com.kdu.assessment.repository;

import com.kdu.assessment.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
    List<Address> findAllByUserId(UUID userId);
    Address findByNickName(String nickName);
}
