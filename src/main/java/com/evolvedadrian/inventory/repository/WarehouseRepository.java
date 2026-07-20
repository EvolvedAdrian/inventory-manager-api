package com.evolvedadrian.inventory.repository;

import com.evolvedadrian.inventory.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
    List<Warehouse> findByName(String name);

    List<Warehouse> findByLocation(String location);
}
