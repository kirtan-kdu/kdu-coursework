package com.kdu.assessment.repository;

import com.kdu.assessment.entities.Inventory;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface InventoryRepository extends JpaRepository<Inventory, UUID> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE inventory SET quantity = :quantity WHERE inventory_id = :inventoryId", nativeQuery = true)
    void updateQuantity(@Param("inventoryId") UUID inventoryId, @Param("quantity") int quantity);


    @Transactional
    @Modifying
    @Query(value = "UPDATE inventory SET name = :name, description = :description, price = :price, quantity = :quantity, threshold = :threshold WHERE inventoryId = :inventoryId", nativeQuery = true)
    int updateDetails(@Param("inventoryId") UUID inventoryId, @Param("name") String name, @Param("description") String description, @Param("price") int price, @Param("quantity") int quantity, @Param("threshold") int threshold);


}

