package com.kdu.assessment.repository;

import com.kdu.assessment.entities.Cart;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Map;
import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE cart SET items = :items WHERE cart_id = :cartId", nativeQuery = true)
    int updateItems(@Param("cartId") UUID cartId, @Param("items") Map<UUID,Integer> items);


}
