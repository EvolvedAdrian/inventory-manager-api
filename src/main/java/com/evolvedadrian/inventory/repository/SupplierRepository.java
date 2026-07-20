package com.evolvedadrian.inventory.repository;

import com.evolvedadrian.inventory.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
