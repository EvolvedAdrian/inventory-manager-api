package com.evolvedadrian.inventory.repository;

import com.evolvedadrian.inventory.entity.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockMovementRepository extends JpaRepository<StockMovement, Integer> {
}
