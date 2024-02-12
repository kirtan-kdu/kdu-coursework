package com.kdu.smarthome.repository;

import com.kdu.smarthome.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InventoryRepository extends JpaRepository<Inventory, String> {
}